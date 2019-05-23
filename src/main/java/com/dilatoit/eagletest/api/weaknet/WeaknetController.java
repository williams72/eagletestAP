package com.dilatoit.eagletest.api.weaknet;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.WeaknetValidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 弱网相关
 * Created by xueshan.wei on 4/19/2017.
 */
@Controller("apiWeaknetController")
@RequestMapping("/api")
@Api(value = "weaknet", description = "弱网相关")
@Scope("prototype")
public class WeaknetController extends BaseController {

    /**
     * 启用弱网项
     * @param wnid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet/{wnid}/availability", method = RequestMethod.POST)
    @ApiOperation(value = "启用弱网项", notes = "",
            httpMethod = "POST", response = ApiResult.class)
    @ApiImplicitParam(name = "wnid",value = "启动弱网wnid",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.WEAKNET_UPDATE)
    public void enable(@PathVariable Integer wnid) throws ApiBusinessException {

        try {
            serviceManager.getWeaknetService().changeAvailability(wnid, true);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_UPDATE_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("启用成功");
    }

    /**
     * 禁用弱网项
     * @param wnid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet/{wnid}/availability", method = RequestMethod.DELETE)
    @ApiOperation(value = "禁用弱网项", notes = "",
            httpMethod = "DELETE", response = ApiResult.class)
    @ApiImplicitParam(name = "wnid",value = "禁用弱网项wnid",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.WEAKNET_UPDATE)
    public void disable(@PathVariable Integer wnid) throws ApiBusinessException{
        try {
            serviceManager.getWeaknetService().changeAvailability(wnid, false);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_UPDATE_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("禁用成功");
    }

    /**
     * 分页查询弱网设置项
     * @param baseQuery
     * @throws ApiBusinessException
     */
    @ApiOperation(value = "分页查询弱网设置项", notes = "",
            httpMethod = "GET", response = ApiResult.class)
    @RequestMapping(value = "/weaknets", method = RequestMethod.GET)
    @AuthorityCheck
    public void queryWeakList(@Valid @RequestBody BaseQuery baseQuery) throws ApiBusinessException{

    }

    /**
     * 添加弱网设置
     * @param weaknetValidate
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet", method = RequestMethod.POST)
    @ApiOperation(value = "添加弱网项", notes = "",
            httpMethod = "POST", response = ApiResult.class)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.WEAKNET_ADD)
    public void addWeaknet(@Valid @RequestBody WeaknetValidate weaknetValidate,
                           BindingResult bindingResult) throws ApiBusinessException{
        if(bindingResult.hasErrors()){
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        Integer newId;
        try {
            newId = serviceManager.getWeaknetService().add(weaknetValidate.getName(),
                    weaknetValidate.getDesc(),
                    weaknetValidate.getParam());
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_INSERT_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        WeaknetDTO weaknetDTO;
        try {
            weaknetDTO = serviceManager.getWeaknetService().querySingleById(newId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        this.renderResult("增加弱网项成功", weaknetDTO);
    }

    /**
     * 查询单个弱网项
     * @param wnid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet/{wnid}", method = RequestMethod.GET)
    @ApiOperation(value = "查询单个弱网项", notes = "",
            httpMethod = "GET", response = ApiResult.class)
    @ApiImplicitParam(name = "wnid",value = "查询单个弱网项wnid",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    public void querySingle(@PathVariable Integer wnid) throws ApiBusinessException{
        WeaknetDTO weaknetDTO;
        try {
            weaknetDTO = serviceManager.getWeaknetService().querySingleById(wnid);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        if(weaknetDTO == null){
            throw new ApiBusinessException(ExceptionEnum.QUERY_ENTITY_NOT_FOUND);
        }
        this.renderResult("查询弱网项成功", weaknetDTO);
    }

    /**
     * 删除弱网项
     * @param wnid
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet/{wnid}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除弱网项", notes="",
            httpMethod = "DELETE", response = ApiResult.class)
    @ApiImplicitParam(name = "wnid",value = "删除弱网项wnid",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.WEAKNET_DELETE)
    public void deleteWeaknet(@PathVariable Integer wnid) throws ApiBusinessException{
        try {
            serviceManager.getWeaknetService().delete(wnid);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_DELETE_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("删除成功");
    }

    /**
     * 更新弱网项
     * @param wnid 弱网项id
     * @param weaknetValidate
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/weaknet/{wnid}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新弱网项", notes="",
            httpMethod = "PUT", response = ApiResult.class)
    @ApiImplicitParam(name = "wnid",value = "更新弱网项wnid",required = true,dataType = "Integer",paramType = "path")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.WEAKNET_UPDATE)
    public void updateWeaknet(@PathVariable Integer wnid, @Valid @RequestBody WeaknetValidate weaknetValidate,
                              BindingResult bindingResult) throws ApiBusinessException{
        if(bindingResult.hasErrors()){
            throw new ApiBusinessException(ExceptionEnum.PARAM_ERROR, bindingResult);
        }
        WeaknetDTO weaknetDTO;
        try {
            weaknetDTO = serviceManager.getWeaknetService().update(wnid, weaknetValidate.getName(),
                    weaknetValidate.getDesc(), weaknetValidate.getParam());
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
        this.renderResult("更新成功", weaknetDTO);
    }
}
