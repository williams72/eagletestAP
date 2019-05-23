package com.dilatoit.eagletest.api.user;


import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.api.model.ApiPageData;
import com.dilatoit.eagletest.dto.UserDTO;
import com.dilatoit.eagletest.dto.translate.UserDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiParameterException;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.AddUser;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by xueshan.wei on 2/9/2017.
 */
@Controller(value = "apiUserController")
@RequestMapping(value = "/api")
@Api(value = "用户相关API", description = "用户相关API")
@Scope("prototype")
public class UserController extends BaseController {
    /**
     * change user`s password
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @throws ApiBusinessException
     */
    @ApiOperation(value = "修改密码", notes = "修改密码接口，用于修改用户密码", httpMethod = "PUT", response = ApiResult.class)
    @RequestMapping(value = "/user/{userId}/password", method = RequestMethod.PUT)
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_UPDATE_PWD)
    public void changePwd(@PathVariable Integer userId, @RequestParam String oldPwd, @RequestParam String newPwd) throws ApiBusinessException {
        try {
            serviceManager.getUserService().changePassword(userId, oldPwd, newPwd);
        } catch (BusinessException e) {
            throw new ApiBusinessException(e.getEe());
        }
        apiResult.reset();
        this.apiResult.setMsg("密码修改成功");
        this.renderObj(apiResult);
    }

    /**
     *
     * @param userId
     * @param newPwd
     * @throws ApiBusinessException
     */
    @ApiOperation(value = "管理员修改用户密码", notes = "修改密码接口，管理员修改用户密码", httpMethod = "PUT", response = ApiResult.class)
    @RequestMapping(value = "/system/user/{userId}/password", method = RequestMethod.PUT)
    @AuthorityCheck(permission = "userPassword:update")
    @SystemControllerLog(systemLog = SystemLog.SYSTEM_USER_PWD_UPDATE)
    public void systemChangePwd(@PathVariable Integer userId, @RequestParam String newPwd) throws ApiBusinessException{
        try {
            serviceManager.getUserService().changePassword(userId, newPwd);
        }catch (BusinessException e){
            throw new  ApiBusinessException(e.getEe());
        }
        apiResult.reset();
        this.apiResult.setMsg("密码修改成功");
        this.renderObj(apiResult);

    }

    /**
     * disable a user
     * @param userId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/user/{userId}/access", method = RequestMethod.DELETE)
    @ApiOperation(value = "禁用用户", notes = "用于禁用某个用户，使其无法登录系统",
        httpMethod = "DELETE", response = ApiResult.class)
    //@ApiImplicitParam(name = "userId", value = "要禁用的用户的id", required = true, dataType = "Integer")
    @AuthorityCheck(permission = "userAccessable:update")
    @SystemControllerLog(systemLog = SystemLog.USER_DISABLE)
    public void disableUser(@PathVariable Integer userId) throws ApiBusinessException{
        try {
            serviceManager.getUserService().disableUser(userId);
            this.renderResult("禁用用户成功");
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    /**
     * enable a user
     * @param userId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/user/{userId}/access", method = RequestMethod.POST)
    @ApiOperation(value = "解禁用户", notes = "用于解禁某个用户，使其可以正常登录系统",
            httpMethod = "POST", response = ApiResult.class)
    @AuthorityCheck(permission = "userAccessable:update")
    @SystemControllerLog(systemLog = SystemLog.USER_ENABLE)
    public void enableUser(@PathVariable Integer userId) throws ApiBusinessException{
        try {
            serviceManager.getUserService().enableUser(userId);
            this.renderResult("解禁用户成功");
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    /**
     * query single user`s infomation
     * @param userId
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "查询单个用户的信息", notes = "用于查看单个用户的信息", httpMethod = "GET",
        response = ApiResult.class)
    @AuthorityCheck
    public void querySingleUser(@PathVariable Integer userId) throws ApiBusinessException{
        EtUser user = null;
        try {
            user = serviceManager.getUserService().queryUserById(userId);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        this.renderResult("查询用户信息成功", user);
    }

    /**
     * 查询所有用户信息
     * @param baseQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询所有用户信息", notes = "用于查询所有用户信息", httpMethod = "GET", response = ApiResult.class)
    @AuthorityCheck
    public void queryAllUsers(BaseQuery baseQuery)throws ApiBusinessException{
        DataPage<EtUser> page = new DataPage<EtUser>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());
        try{
            serviceManager.getUserService().page(page);
            ApiPageData apiPageData = new ApiPageData(page.getRows(), page.getLimit(), page.getOffset(), page.getData());
            this.renderResult("分页查询所有用户信息成功", apiPageData);
        }catch (DataBaseException e){
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }
    }

    /**
     * add a new user
     * @param addUser
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", notes = "用于新增一个用户", httpMethod = "POST", response = ApiResult.class)
    //@ApiImplicitParam(name = "addUser", value = "新增用户实体", dataType = "AddUser")
    @AuthorityCheck(permission = "user:add")
    @SystemControllerLog(systemLog = SystemLog.USER_ADD)
    public void addUser(@Valid @RequestBody AddUser addUser, BindingResult bindingResult) throws ApiBusinessException{
        if (bindingResult.hasErrors()) {
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        } else {
            EtUser newUser = new EtUser();
            newUser.setUsername(addUser.getAccount());
            newUser.setEmail(addUser.getEmail());
            newUser.setPassword(addUser.getPassword());
            newUser.setAvatars("user_default.png");
            try {
                newUser = serviceManager.getUserService().addUser(newUser);
            } catch (DataBaseException e) {
                e.printStackTrace();
                throw new ApiBusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            } catch (BusinessException e) {
                e.printStackTrace();
                throw new ApiBusinessException(e.getEe());
            }
            UserDTO userDTO = UserDTOTranslate.translate(newUser);
            renderResult("新增用户成功", userDTO);
        }
    }
}
