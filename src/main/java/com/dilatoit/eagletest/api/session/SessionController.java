package com.dilatoit.eagletest.api.session;

import com.dilatoit.eagletest.annotation.AuthorityCheck;
import com.dilatoit.eagletest.annotation.SystemControllerLog;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.dto.UserDTO;
import com.dilatoit.eagletest.dto.translate.UserDTOTranslate;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.log.SystemLog;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiParameterException;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.dilatoit.eagletest.validate.api.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by xueshan.wei on 2/15/2017.
 */
@Controller(value = "apiSessionController")
@RequestMapping(value = "/api")
@Api(value = "session", description = "用户session 相关API")
@Scope("prototype")
public class SessionController extends BaseController {

    /**
     * user login
     * @param login
     * @param bindingResult
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用于用户登录系统，输入身份认证信息后通过本API进行身份认证", response = ApiResult.class)
    //@ApiImplicitParam(name = "login", value = "登录数据实体", required = true, dataType = "Login")
    @SystemControllerLog(systemLog = SystemLog.USER_LOGIN)
    public void login(@Valid @RequestBody Login login, BindingResult bindingResult) throws ApiBusinessException {
        if (bindingResult.hasErrors()) {
            throw new ApiParameterException(ExceptionEnum.PARAM_ERROR, bindingResult);
        } else {
            try {
                EtUser user = serviceManager.getUserService().login(login.getAccount(), login.getPassword());
                UserDTO userDTO = UserDTOTranslate.translate(user);

                userDTO.setSessionId(session.getId());
                session.setAttribute("currentUser", user);
                renderResult("登录成功", userDTO);
            } catch (BusinessException be) {
                throw new ApiBusinessException(be.getEe());
            }

        }
        //this.renderResult();
    }

    /**
     * 用户注销登录
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.DELETE)
    @ApiOperation(value = "用户注销登录", notes = "用于用户注销登录", response = ApiResult.class,
            httpMethod = "DELETE")
    @AuthorityCheck
    @SystemControllerLog(systemLog = SystemLog.USER_LOGOUT)
    public void logout() throws ApiBusinessException {
        session.setAttribute("currentUser", null);
        this.renderResult("注销登录成功");
    }

    /**
     * 获取当前登录用户的信息
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ApiOperation(value = "得到当前登录用户的信息", notes = "用于获取当前登录用户的信息", response = ApiResult.class, httpMethod = "GET")
    @AuthorityCheck
    public void currentUser() throws ApiBusinessException {
        EtUser currentUser = (EtUser) session.getAttribute("currentUser");
        if (currentUser != null) {
            this.renderResult("查询当前用户信息成功", currentUser);
        }
    }
}
