package com.dilatoit.engine.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xueshan.wei on 6/16/2017.
 */
public class EngineCreateTaskResultDTO {
    private boolean success;
    private long id;
    private Map result = new HashMap<>();

    @Override
    public String toString() {
        return "EngineCreateTaskResultDTO{" +
                "success=" + success +
                ", id=" + id +
                ", result=" + result +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }
}
