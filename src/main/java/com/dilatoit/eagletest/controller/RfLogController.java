package com.dilatoit.eagletest.controller;

import com.dilatoit.commons.http.HttpUtils;
import com.dilatoit.eagletest.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

/**
 * Created by xueshan.wei on 6/30/2017.
 */
@Controller
public class RfLogController extends BaseController{

    @RequestMapping("/rfResult")
    public String getRfResult(@RequestParam String url, @RequestParam String taskId, @RequestParam String serialNum,
                              @RequestParam String fileName, Model model){

        fileName = taskId + "-" + serialNum + "-" + fileName;
        String tempFilePath =  request.getSession().getServletContext().getRealPath("/") + "static" + File.separator
                + "et_data" + File.separator + "rf_result" + File.separator + fileName;
        File file = new File(tempFilePath);
        if (!file.exists()){
            try {
                HttpUtils.downloadFile(url, tempFilePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("fileName", fileName);
        return "task/rf_result";
    }
}
