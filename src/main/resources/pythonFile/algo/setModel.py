import pandas as pd
import math
from scipy.optimize import minimize
import numpy as np
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
from sklearn.cluster import *
import pymysql
from sklearn import svm
from sklearn.metrics import accuracy_score
import pickle
import os

def preprocess():
    # 通过pymysql读取数据库
    con = pymysql.connect(host="127.0.0.1", user="root", password="Ychf1998", db="mlc")
    raw_data = pd.read_sql("select * from info ", con)
    data = raw_data.iloc[:, 18:29]
    data=data.drop(columns=['sixteen','eighteen','nineteen','twentythree'])

    # 将用户在各方面支出除以总收入，得到支出占比
    length = len(data)
    data.iloc[:, 0] = round(data.iloc[:, 0] / 12, 2)
    data.iloc[:, -2] = round(data.iloc[:, -2] / 12, 2)

    for i in range(length):
        data.iloc[i] = round(data.iloc[i] / sum(data.iloc[i]), 2)

    data = data.applymap(lambda x: x if x > 0 else 1)
    data['twentyfour']=raw_data.iloc[:,29]
    # print(data.describe())
    return data


def cluster(data):
    def kMeans(data, n=5):
        kmeans = KMeans(n_clusters=n)
        kmeans.fit(data)
        labelPred = kmeans.labels_
        return labelPred

    def meanShift(data):
        bandwidth = estimate_bandwidth(data, quantile=0.2, n_samples=100)
        ms = MeanShift(bandwidth=bandwidth, bin_seeding=True)
        ms.fit(data)
        labelPred = ms.labels_

        labels_unique = np.unique(labelPred)
        n_clusters_ = len(labels_unique)
        return labelPred, n_clusters_

    def gmm(data, n):
        from sklearn.mixture import GaussianMixture
        gmm = GaussianMixture(n)
        gmm.fit(data)
        labelPred = gmm.predict(data)
        return labelPred

    def ap(data):
        ap = AffinityPropagation()
        ap.fit(data)
        labelPred = ap.labels_
        labels_unique = np.unique(labelPred)
        n_clusters_ = len(labels_unique)
        return labelPred, n_clusters_

    if __name__ == "__main__":

        # # 先对每列数据进行kMeans聚类分为5类，用labels代替其值
        # columns = data.shape[1]
        # labeled_data = data

        # data['twentyfour'] = data['twentyfour'].apply(lambda x: round(4.3 * (x - np.min(x)) / (np.max(x) - np.min(x))))
        # print(data['twentyfour'])
        # x=data.iloc[:,-1]
        # min_x=np.min(x)
        # max_x = np.max(x)
        # for i  in range(0,len(x)):
        #     x[i]=round(4.3 * (x[i] - min_x) / (max_x - min_x))
        # print(x)
        # data.iloc[:,-1]=x

        result = []
        n = 8
        ##############################
        # 选择一种聚类算法进行聚类
        result = kMeans(data, 8)
        # result, n = meanShift(data)
        # result = gmm(data, 8)
        # result, n = ap(data)
        ##############################


        data['class'] = result
        return data, n


def regression(raw_data, n):
    def getData(i):
        data = raw_data[raw_data['class'] == i]
        # 清洗不需要的数据
        data = data.iloc[:, :-1]
        data = data.applymap(lambda x: math.log(x) if x != 0 else 0)
        return data

    def showRes(model, X_train, Y_train):
        Y_pred = model.predict(X_train)
        plt.plot(range(len(Y_pred)), Y_pred, 'b', label="predict")
        plt.plot(range(len(Y_pred)), Y_train, 'r', label="test")
        plt.legend(loc="upper right")  # 显示图中的标签
        plt.xlabel("user")
        plt.ylabel('user_satisfaction')
        plt.show()

    def regress(data):
        # X_train, X_test, Y_train, Y_test = train_test_split(data.iloc[:, :-1], data.iloc[:, -1], train_size=.999,test_size=.001)
        X_train=data.iloc[:,:-1]
        Y_train=data.iloc[:,-1]
        model = LinearRegression()
        model.fit(X_train, Y_train)
        a = model.intercept_  # 截距
        b = model.coef_  # 回归系数

        # R方检测
        # 决定系数r平方#对于评估模型的精确度
        # y误差平方和 = Σ(y实际值 - y预测值)^2
        # y的总波动 = Σ(y实际值 - y平均值)^2
        # 有多少百分比的y波动没有被回归拟合线所描述 = SSE/总波动
        # 有多少百分比的y波动被回归线描述 = 1 - SSE/总波动 = 决定系数R平方
        # 对于决定系数R平方来说1） 回归线拟合程度：有多少百分比的y波动刻印有回归线来描述(x的波动变化)
        # 2）值大小：R平方越高，回归模型越精确(取值范围0~1)，1无误差，0无法完成拟合
        score = model.score(X_train, Y_train)
        # showRes(model, X_train, Y_train)

        return score, a, b

    def calStrategy(intercept, coef):
        # 目标函数
        def func(x):
            res = -math.pow(math.e, intercept)
            for i in range(len(coef)):
                res *= math.pow(x[i], coef[i])
            return res

        # 约束
        cons = ({'type': 'ineq',
                 'fun': lambda x: 1 - x[0] - x[1] - x[2] - x[3] - x[4] - x[5] - x[6] })
        x0 = np.array((0.14, 0.14, 0.14, 0.14, 0.14, 0.14, 0.14))  # 设置初始值

        e = 1e-10
        bound = (e, 1)
        bounds = (bound, bound, bound, bound, bound, bound, bound)
        res = minimize(func, x0, method='SLSQP', bounds=bounds, constraints=cons)
        print('最大值：', -res.fun)
        print('最优解：', res.x)
        print('迭代终止是否成功：', res.success)
        print('迭代终止原因：', res.message)
        return res.x, res.success

    if __name__ == "__main__":
        file = 'param.txt'

        f = open(file, 'w')
        if f.__exit__():
            f.write("")
        f.close()
        f=open(file,"a")
        for i in range(n):
            data = getData(i)

            print('class {}'.format(i))
            print('len:{}'.format(data.shape[0]))


            if data.shape[0] == 1:
                print('------------------')
                print()
            else:
                s, intercept, coefficient = regress(data)
                print("Final Score: {:.4f}".format(s))
                print("可行结果: 截距= ", intercept, "回归系数: ", coefficient)
                strategy, state = calStrategy(intercept, coefficient)
                print('------------------')
                print()
                f.write(str(i)+";"+str(state)+";")
                f.write("{:.4f};".format(intercept))
                f.write(" ".join(["{:.4f}".format(i) for i in coefficient.tolist()]))
                f.write("\n")

        f.close()


def setModel(raw_data):
    def getModel():
        data =raw_data.iloc[:,:-1]
        target = raw_data.iloc[:, -1]
        clf = svm.SVC(C=1, kernel='rbf', gamma=1, decision_function_shape='ovo')
        # clf = svm.SVC(C=1, kernel='linear', decision_function_shape='ovr')
        clf.fit(data, target)
        target_hat = clf.predict(data)
        acc = accuracy_score(target, target_hat)
        np.set_printoptions(suppress=True)
        print(u'预测正确的样本个数：%d，正确率：%.2f%%' % (round(acc * len(data)), 100 * acc))
        return clf

    def dump(model, filename):
        with open(filename, 'wb') as fp:
            pickle.dump(model, fp)

    if __name__ == "__main__":
        clf = getModel()
        dump(clf, 'model')


data = preprocess()
data, n = cluster(data)
regression(data, n)
setModel(data)