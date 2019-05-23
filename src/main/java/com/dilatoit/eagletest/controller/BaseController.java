package com.dilatoit.eagletest.controller;

import com.dilatoit.eagletest.service.impl.ServiceManager;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
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
@Controller
public class BaseController {
    private final static String CONTENT_TYPE = "application/json";
    @Autowired
    protected ServiceManager serviceManager;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected Gson gson;

    @PostConstruct
    public void init(){
        gson = new Gson();
        //new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
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
}
