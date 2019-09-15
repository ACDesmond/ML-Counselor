package com.ninova.mlc.vo;

import java.sql.Timestamp;

public class MessageItem {
    private String name;
    private double growthRate;
    private Timestamp time1;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public Timestamp getTime1() {
        return time1;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public void setTime1(Timestamp time1) {
        this.time1 = time1;
    }
}
