package com.ninova.mlc.vo;

import java.util.List;

public class Message {
    private double totalInput;
    private double total;
    private double totalIncome;
    private List<MessageItem> scheme;

    public double getTotal() {
        return total;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalInput() {
        return totalInput;
    }

    public List<MessageItem> getScheme() {
        return scheme;
    }

    public void setScheme(List<MessageItem> scheme) {
        this.scheme = scheme;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalInput(double totalInput) {
        this.totalInput = totalInput;
    }
}
