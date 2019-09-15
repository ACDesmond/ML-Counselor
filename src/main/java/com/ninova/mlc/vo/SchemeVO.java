package com.ninova.mlc.vo;

import java.util.ArrayList;

public class SchemeVO {

    //从小到大是不同股票，按综合收益率从高到低排行
    ArrayList<String> stockRank;

    ArrayList<Double>  Comsumption_ration;

    ArrayList<Double> plus_or_minus;

    public ArrayList<Double> getPlus_or_minus() {
        return plus_or_minus;
    }

    public void setPlus_or_minus(ArrayList<Double> plus_or_minus) {
        this.plus_or_minus = plus_or_minus;
    }


    public ArrayList<Double> getComsumption_ration() {
        return Comsumption_ration;
    }

    public void setComsumption_ration(ArrayList<Double> comsumption_ration) {
        Comsumption_ration = comsumption_ration;
    }



    public ArrayList<String> getStockRank() {
        return stockRank;
    }

    public void setStockRank(ArrayList<String> stockRank) {
        this.stockRank = stockRank;
    }


}
