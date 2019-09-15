package com.ninova.mlc.vo;

import java.util.List;

public class DailyBenefitVO {
    private String date;
    private List<Double> list;

    public List<Double> getBenefits() {
        return list;
    }

    public String getDate() {
        return date;
    }

    public void setBenefits(List<Double> benefits) {
        this.list = benefits;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
