package com.dilatoit.eagletest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * api doc controler
 * Created by xueshan.wei on 3/28/2017.
 */
@Controller
@RequestMapping
public class ApiDocController extends BaseController {

    @RequestMapping(value = "/api-doc")
    public String toApiDoc() throws Exception{
        return "/apidoc/index";
    }
}
