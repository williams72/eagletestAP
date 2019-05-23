package com.dilatoit.eagletest.service.impl;

import javax.annotation.Resource;

import com.dilatoit.eagletest.dao.impl.BaseDAO;
import com.dilatoit.engine.pipes.EnginePipe;
import org.springframework.stereotype.Controller;

@Controller(value="baseService")
public class BaseService<T>{
	@Resource(name="baseDAO")
	protected BaseDAO<T> baseDAO;

    @Resource(name = "mtcEnginePipe")
    protected EnginePipe enginePipe;

    public BaseService(){

    }
}
