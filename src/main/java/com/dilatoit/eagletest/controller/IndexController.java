package com.dilatoit.eagletest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xueshan.wei on 11/25/2016.
 */
@Controller
@RequestMapping
public class IndexController {
    /**
     * 设置 首页
     *
     * 可以在这里读取该用户上次访问的project 然后转到 该项目
     * @return
     */
    @RequestMapping("/")
    public String index(){
        //return "login";
        return "redirect:/login";
    }

    @RequestMapping(value = "/mainpage")
    public String mainPage(){
        return "redirect:/moreproject";
    }
}
