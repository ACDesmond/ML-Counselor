package com.ninova.mlc.vo;

import java.util.List;

public class TraceVO {
    private DailyBenefitVO[] rows;
    private List<String> columns;

    public DailyBenefitVO[] getRows() {
        return rows;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void setRows(DailyBenefitVO[] rows) {
        this.rows = rows;
    }
}
