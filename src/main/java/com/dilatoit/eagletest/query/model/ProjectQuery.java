package com.dilatoit.eagletest.query.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xueshan.wei on 2/9/2017.
 */
@ApiModel(value = "查询项目条件的实体")
public class ProjectQuery extends BaseQuery{
    @ApiModelProperty(value = "要查询项目名",example = "安卓项目")
    private String name;
    @ApiModelProperty(value = "要查询的项目的key",example = "AZ")
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
