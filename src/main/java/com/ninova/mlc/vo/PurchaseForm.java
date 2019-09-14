package com.ninova.mlc.vo;

import java.sql.Timestamp;

public class PurchaseForm {
    private int userId;
    /**
     * 产品名
     */
    private String name;
    /**
     * 产品代号
     */
    private String code;
    /**
     * 本金
     */
    private double principal;
    /**
     * 购买数量
     */
    private float number;
    /**
     * 产品类型 0为公司理财产品 1为基金 2为股票 3为债券
     */
    private int type;
    /**
     * 购买时间
     */
    private Timestamp startTime;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrincipal() {
        return principal;
    }

    public float getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }

    public int getType() {
        return type;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setType(int type) {
        this.type = type;
    }
}
