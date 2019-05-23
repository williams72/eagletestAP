package com.dilatoit.eagletest.api.log;


import com.dilatoit.eagletest.api.base.BaseController;
import com.dilatoit.eagletest.api.model.ApiPageData;
import com.dilatoit.eagletest.dto.translate.LogDTOTranslate;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.api.ApiBusinessException;
import com.dilatoit.eagletest.model.EtLog;
import com.dilatoit.eagletest.query.model.BaseQuery;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.validate.api.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by xueshan.wei on 3/10/2017.
 */
@CrossOrigin(origins = "*")
@Api(value = "日志接口", description = "日志相关接口")
@RequestMapping(value = "/api")
@Controller(value = "apiLogController")
@Scope("prototype")
public class LogController extends BaseController {
    /**
     * 查询日志
     * @param baseQuery
     * @throws ApiBusinessException
     */
    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    @ApiOperation(value = "查询日志", notes = "用于查询日志",
            httpMethod = "GET", response = ApiResult.class)
    public void getLogs(BaseQuery baseQuery) throws ApiBusinessException {
        DataPage<EtLog> page = new DataPage<EtLog>();
        page.setOffsetLimit(baseQuery.getOffset(), baseQuery.getLimit());

        try {
            serviceManager.getLogService().page(page);
            ApiPageData apd = new ApiPageData(page.getRows(), page.getLimit(),
                    page.getOffset(), LogDTOTranslate.translateList(page.getData()));
            this.renderResult("查询日志成功",apd);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw new ApiBusinessException(e.getEe());
        }

    }
    @RequestMapping(value = "/alllogs", method = RequestMethod.GET)
    public void getAllLogs() throws ApiBusinessException{
        List<EtLog> logs = null;
        try {
            logs = serviceManager.getLogService().queryAll();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        this.renderResult("success", LogDTOTranslate.translateList(logs));
    }
}
