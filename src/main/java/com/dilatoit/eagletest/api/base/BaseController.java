package com.dilatoit.eagletest.api.base;


import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.service.impl.ServiceManager;
import com.dilatoit.eagletest.validate.api.ApiResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by beishan on 2016/11/15.
 */
@Controller(value = "apiBaseController")
@Scope("prototype")
public class BaseController {
    private final static String CONTENT_TYPE = "application/json";
    @Autowired
    protected ServiceManager serviceManager;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected Gson gson;
    @Autowired
    protected ApiResult apiResult;

    @PostConstruct
    public void init(){
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        System.out.println("session id :" + session.getId());
    }

    /**
     * render a String mesg
     * @param mesg
     */
    public void render(String mesg){
        try{
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(mesg);
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * render a Object as json
     * @param json
     */
    public void renderObj(Object json){
        try{
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(gson.toJson(json));
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * render a Object as json
     * @param json
     */
    public void renderObj(Object json, Type listType){
        try{
            //gson.toJson(json, listType);
            response.setContentType(CONTENT_TYPE + ";charset=UTF-8");
            response.getWriter().print(gson.toJson(json,listType));
            response.getWriter().flush();
            response.getWriter().close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 回传api 调用结果
     * 请改用另外一个带参数的方法，比这个方法更简单，可以直接传入要回写的结果
     */
    @Deprecated
    public void renderResult(){
        this.renderObj(this.apiResult);
    }

    public void renderResult(String msg) {
        this.renderResult(msg, null);
    }

    public void renderResult(String msg, Object data){
        apiResult.reset();
        apiResult.setApiResult(msg, data);
        this.renderObj(this.apiResult);
    }

    public void renderResult(String code, String msg, Object data){
        apiResult.setCode(code);
        apiResult.setApiResult(msg, null);
        this.renderObj(this.apiResult);
    }


    public EtUser getCurrentUser(){
        return (EtUser) session.getAttribute("currentUser");
    }
}
