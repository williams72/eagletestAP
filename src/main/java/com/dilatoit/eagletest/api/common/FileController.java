package com.dilatoit.eagletest.api.common;
import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;

import com.dilatoit.eagletest.util.Tools;
import com.dilatoit.eagletest.validate.filetree.FileTree;

import com.dilatoit.eagletest.validate.filetree.FileTreeUtil;
import com.dilatoit.eagletest.validate.filetree.NodeState;
import com.dilatoit.eagletest.util.FileUtil;
import com.dilatoit.engine.engines.mtc.util.JsonTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Salt on 2017/7/14.
 */

@Controller("fileController")
@Api(value = "file", description = "文件相关")
@RequestMapping(value = "/api/common")
@Scope("prototype")
public class FileController extends BaseController {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "文件名", required = true, dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "file", value = "脚本文件", required = true, dataType = "file(zip)",paramType = "request")})
    @RequestMapping(value = "/scriptfile/upload", method = RequestMethod.POST)
    public void uploadCaseFile(@RequestParam String fileName, @RequestParam MultipartFile file) throws ApiBusinessException{
        if (file != null) {
            String tempFilePath = Tools.getTempPath() + File.separator + "others";
            File tempFile = null;
            try {
                tempFile = FileUtil.transferFile(file, new File(tempFilePath));
            }catch (IOException e){
                e.printStackTrace();
            }

            String resultStr;
            try{
                resultStr = serviceManager.getCommonsService().uploadCaseFile("file", tempFile, fileName);
                System.out.println(resultStr);
            }catch (BusinessException e){
                throw new ApiBusinessException(ExceptionEnum.MTC_CONFIG_API_ERROR);
            }
            Map result = JsonTools.toMap(resultStr);
            String url = (String)result.get("url");
            this.renderResult("上传脚本文件成功", url);
        }else {
            throw new ApiBusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "文件名", required = true, dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file",paramType = "request")})
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public void uploadFile(@RequestParam String fileName, @RequestParam MultipartFile file) throws ApiBusinessException{

        if (file != null) {
            String tempFilePath = Tools.getTempPath() + File.separator + "others";
            File tempFile = null;
            try {
                tempFile = FileUtil.transferFile(file, new File(tempFilePath));
            }catch (IOException e){
                e.printStackTrace();
            }
            String resultStr;
            try{
                resultStr = serviceManager.getCommonsService().uploadFile("file", tempFile, fileName);
                System.out.println(resultStr);
            }catch (BusinessException e){
                throw new ApiBusinessException(ExceptionEnum.MTC_CONFIG_API_ERROR);
            }
            Map result = JsonTools.toMap(resultStr);
            String url = (String)result.get("url");

            this.renderResult("上传文件成功", url);
        }else {
            throw new ApiBusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "file",paramType = "request")
    @RequestMapping(value = "/file/analysis", method = RequestMethod.POST)
    public void uploadFileAndAnalysis(@RequestParam MultipartFile file) throws ApiBusinessException{
        if(file != null){
            //转换至本地文件
            String tempFilePath = Tools.getTempPath() + File.separator + "others";
            File tempFile = null;
            try {
                tempFile = FileUtil.transferFile(file, new File(tempFilePath));
            }catch (IOException e){
                e.printStackTrace();
            }

            //解压zip文件
            String unZipPath = "";
            if(tempFile != null){
                //System.out.println(localFile.getPath());
                try {
                    unZipPath = FileUtil.unZipFile(tempFile.getAbsolutePath(), tempFilePath);
                    System.out.println(unZipPath);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

            //遍历解压文件夹，并去除首层目录
            FileTreeUtil fileTreeUtil = new FileTreeUtil();
            FileTree fileTree = fileTreeUtil.translateToFileTree(unZipPath, unZipPath).getChildren().get(0);
            //设置全选状态
            NodeState state = new  NodeState(true);
            fileTree.setState(state);
            //String fileTreeJson = GsonUtils.toJsonString(fileTree);
            this.renderResult("解析文件树成功！", fileTree);

        }

    }

}
