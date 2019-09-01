# -*- coding: utf-8 -*-
"""
Created on Fri Jul 19 09:48:01 2019

@author: X1
"""

from sklearn.ensemble import IsolationForest
from sklearn.ensemble import GradientBoostingRegressor
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt


def label_by_quantile(r,quantiles=(0.2,0.4,0.6,0.8)):
    '''五层划分'''
    first,second,third,fourth=r.quantile(quantiles)
    label=pd.np.repeat(pd.np.nan,len(r))
    label[r<first]=4
    label[r>=first]=3
    label[r>=second]=2
    label[r>=third]=1
    label[r>=fourth]=0
    return label



def return_rate(temp,day=1):
    '''算周增长益率'''
    rate=((temp-temp.shift(day))/temp.shift(day))[day:]
    return rate



#--------------读取数据，并预处理-------------------------
close=pd.read_pickle(r"D:\花旗杯\mlc\src\main\resources\stock_records\close_2018.pkl")
close.dropna(how='all',axis=1,inplace=True)
high=pd.read_pickle(r"D:\花旗杯\mlc\src\main\resources\stock_records\high_2018.pkl")
high.dropna(how='all',axis=1,inplace=True)
low=pd.read_pickle(r"D:\花旗杯\mlc\src\main\resources\stock_records\low_2018.pkl")
low.dropna(how='all',axis=1,inplace=True)
volume=pd.read_pickle(r"D:\花旗杯\mlc\src\main\resources\stock_records\volume_2018.pkl")
volume.dropna(how='all',axis=1,inplace=True)
turn=pd.read_pickle(r"D:\花旗杯\mlc\src\main\resources\stock_records\turn_2018.pkl")
turn.dropna(how='all',axis=1,inplace=True)


#--------------------------写因子------------------------
#日收益率
reclose=return_rate(close,1)
#周收益率
close_week=return_rate(close,4)
#周量比
volume_week=(volume/(volume.rolling(5,min_periods=1).mean()))[4:]
#周动量
momentum_week=(close/close.shift(4))[4:]
#周平均换手率
turn_week=(turn.rolling(5,min_periods=1).mean())[4:]


#-------------------孤立森林找出异常值------------------------------

#得到训练集
train=pd.DataFrame()
split_line=238#划分数据的分界线
#split_line=len(turn_week)//5*4#划分数据的分界线
#根据日收益率，将股票分层,并去除停盘股票,用80%的股票作为训练集
for i in range(0,split_line,5):
    label=pd.DataFrame()
    label['reclose']=reclose.iloc[i,:]
    label['volume_week']=volume_week.iloc[i,:]
    label['momentum_week']=momentum_week.iloc[i,:]
    label['turn_week']=turn_week.iloc[i,:]
    label['close_week']=close_week.iloc[i,:]
    label.dropna(how='any',axis=0,inplace=True)
    train=pd.concat([train,label])
X=train.iloc[:,1:].values
y=train.iloc[:,0].values


#孤立森林模型设立
IF = IsolationForest(n_estimators=100,behaviour='new',contamination='auto')
IF.fit(X)


#构建哑变量，正常值为0，异常值为1
D=IF.predict(X)
D[D==1]=0
D[D==-1]=1
D=D.reshape(-1,1)
X=np.concatenate([X,D],axis=1)



#得到测试集
label=pd.DataFrame()
prediction=[]
result_index=[]
end=len(close_week)
for i in range(split_line,end):
    label['volume_week']=volume_week.iloc[i,:]
    label['momentum_week']=momentum_week.iloc[i,:]
    label['turn_week']=turn_week.iloc[i,:]
    label['close_week']=close_week.iloc[i,:]
    label.dropna(how='any',axis=0,inplace=True)
    prediction.append(label.values)
    result_index.append(label.index.tolist())
    label=pd.DataFrame()


#加哑变量
for i in range(len(prediction)):
    IF.fit(prediction[i])
    d=IF.predict(prediction[i])
    d[d==1]=0
    d[d==-1]=1
    d=d.reshape(-1,1)
    prediction[i]=np.concatenate([prediction[i],d],axis=1)



#-------------------GBDT回归预测-----------------
first_return=[]
second_return=[]
third_return=[]
fourth_return=[]
fifth_return=[]
market_return=[]
GBDT=GradientBoostingRegressor(n_estimators=100,subsample=0.8,loss='huber')
GBDT.fit(X,y)


for i in range(len(prediction)):
    result_predict=GBDT.predict(prediction[i])
    result_real=reclose.iloc[split_line+i,:][result_index[i]]
    #显示预测值和真实值结果
    result_df=pd.DataFrame({'result_predict':result_predict,'result_real':result_real},index=result_index[i])
    result_df=result_df.sort_values(by='result_predict',ascending=False)
    label=label_by_quantile(result_df.iloc[:,0])
    df_num=pd.DataFrame({'num':label},index=result_df.index)
    
    first=df_num[df_num==0].dropna().index.tolist()
    first_return.append(reclose.iloc[split_line+i,:][first].mean())
    
    '''second=df_num[df_num==1].dropna().index.tolist()
    second_return.append(reclose.iloc[split_line+i,:][second].mean())
    
    third=df_num[df_num==2].dropna().index.tolist()
    third_return.append(reclose.iloc[split_line+i,:][third].mean())  
    
    fourth=df_num[df_num==3].dropna().index.tolist()
    fourth_return.append(reclose.iloc[split_line+i,:][fourth].mean())'''
    
    fifth=df_num[df_num==4].dropna().index.tolist()
    fifth_return.append(reclose.iloc[split_line+i,:][fifth].mean())
    
    market_return.append(reclose.iloc[split_line+i,:].mean())
    print(result_df.head(5))
    
    
#画图
t=list(range(len(prediction)))
plt.figure(figsize=(12,9),dpi=100)
plt.plot(t,first_return,color='red',label='first')
#plt.plot(t,second_return,color='green',label='second')
#plt.plot(t,third_return,color='black',label='third')
#plt.plot(t,fourth_return,color='blue',label='fourth')
plt.plot(t,fifth_return,color='green',label='fifth')
plt.plot(t,market_return,color='black',label='market_mean')
plt.legend(loc='upper left')
plt.show()


#因子特征重要性
factor_names=['volume_week','momentum_week','turn_week','close_week','Dummy']
rank=GBDT.feature_importances_
dfrank=pd.DataFrame(rank,index=factor_names,columns=['scores'])
dfrank.plot(kind='bar')

    
    
    
    
    
    