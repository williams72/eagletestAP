package com.dilatoit.eagletest.query.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * basequery
 * Created by xueshan.wei on 2/10/2017.
 */
@ApiModel(value = "分页查询参数|待问")
public class BaseQuery {
    @ApiModelProperty(value = "页大小(每页条数)",required = true,dataType = "int",example = "10")
    protected int limit;
    @ApiModelProperty(value = "当前页", dataType = "int", required = true, example = "2")
    protected int offset;
    protected String sort;
    protected String order;

    public BaseQuery(){
        limit = 10;
        offset = 1;
    }
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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
}
