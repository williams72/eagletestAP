package com.dilatoit.eagletest.util;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by beishan on 2016/11/12.
 */
public class DataPage<T> {
    @Expose
    private int rows;
    @Expose
    private int offset;
    @Expose
    private int limit;
    @Expose
    private List<T> data;

    public DataPage(){
        offset = 1;
        limit = 10;
    }
    public void setOffsetLimit(int offset, int limit){
        this.offset = offset;
        this.limit = limit;
    }
    public int start(){
        return offset > 0 ? (offset - 1) * limit : 0;
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
