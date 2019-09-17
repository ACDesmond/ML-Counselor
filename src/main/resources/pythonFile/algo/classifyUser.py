import numpy as np
import pandas as pd
import sys
from sklearn import svm
from sklearn.metrics import accuracy_score
import pickle
import pymysql
import os


def load(filename):
    module_path = os.path.dirname(__file__)
    filename = module_path + '\\'+filename
    with open(filename, 'rb') as fp:
        return pickle.load(fp, encoding='latin1')
    print('end')

def preprocess(raw_data, userId):
    data = raw_data.iloc[userId:userId + 1, 18:29]
    data = data.drop(columns=['sixteen', 'eighteen', 'nineteen', 'twentythree'])
    data.iloc[:, 0] = round(data.iloc[:, 0] / 12, 2)
    data.iloc[:, -2] = round(data.iloc[:, -2] / 12, 2)
    data.iloc[0] = round(data.iloc[0] / sum(data.iloc[0]), 2)
    data = data.applymap(lambda x: x if x > 0 else 1)
    data['twentyfour'] = raw_data.iloc[:, 29]
    return data

def getUser():
    # 接受参数
    parameterList = sys.argv
    targetUser = int(parameterList[1])
    # 连接数据库
    con = pymysql.connect(host="127.0.0.1", user="root", password="ninova", db="mlc")
    raw_data = pd.read_sql("select * from info ", con)
    data=preprocess(raw_data,targetUser)
    return data

clf = load('model')
data=getUser()
predict_target = clf.predict(data)
module_path = os.path.dirname(__file__)
file = module_path + '\\param.txt'
f= open(file,"r")
content=f.read().split("\n")
for line in content:
    param = line.split(";")
    if int(param[0])==predict_target[0]:

        coef=param[-1].split()
        raw_data=data.iloc[0]
        data=sorted(data.iloc[0])
        res=[0,0,0,0,0,0,0]
        for n in range(len(coef)):
            rank=0
            for i in range(len(coef)):
                if(coef[n]>coef[i]):
                    rank+=1
            res[n]=data[rank]
        print(" ".join(["{:.2f}".format(i) for i in res]))
        print(" ".join(["{:.2f}".format(raw_data[i]-res[i]) for i in range(len(coef))]))
        break