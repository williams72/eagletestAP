package com.dilatoit.eagletest.api.model;

import com.google.gson.annotations.Expose;

/**
 * Created by xueshan.wei on 3/9/2017.
 */
public class ApiPageData {

    @Expose
    private int rows;
    @Expose
    private int limit;
    @Expose
    private int offset;
    @Expose
    private Object data;

    public ApiPageData(){

    }
    public ApiPageData(int rows, int limit, int offset, Object data) {
        this.rows = rows;
        this.limit = limit;
        this.offset = offset;
        this.data = data;
    }

    public void setApiPageData(int  rows, int limit, int offset, Object data){
        this.rows = rows;
        this.limit = limit;
        this.offset = offset;
        this.data = data;
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
