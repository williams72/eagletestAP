package com.dilatoit.engine;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.EngineEnum;
import com.dilatoit.engine.enums.MobileOsEnum;
import com.dilatoit.engine.exception.EngineException;
import com.dilatoit.engine.pipes.MobilePipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备引擎管理
 * Created by xueshan.wei on 6/9/2017.
 */
@Component
public class MobileEngineManager {
    private static Logger LOGGER = LoggerFactory.getLogger(MobileEngineManager.class);

    @Autowired
    private MobilePipe eteMobilePipe;
    @Autowired
    private MobilePipe mtcMobilePipe;

    /**
     * query mobiles from engine,
     * 0 表示从ete 引擎取
     * 1 表示从mtce 引擎取
     * 2 表示从所有引擎取
     * @param engineEnum 0 ete | 1 mtce | 2 all engine
     * @return
     * @throws EngineException
     */
    public List<MobileDTO> getAllMobileByEngine(EngineEnum engineEnum) throws EngineException{
        List<MobileDTO> list = new ArrayList<>();
        if(engineEnum.value() == EngineEnum.ENGINE_ETE.value()){
            //从ete引擎查询设备信息
            List<MobileDTO> eteMobiles = eteMobilePipe.queryMobiles();
            list.addAll(eteMobiles);
        }else if(engineEnum.value() == EngineEnum.ENGINE_MTCE.value()){
            //从mtc 引擎查询设备信息
            List<MobileDTO> mtcMobiles = mtcMobilePipe.queryMobiles();
            list.addAll(mtcMobiles);
        }else {
            //从所有引擎查询设备信息
            list.addAll(getAllEngineMobiles());
        }
        return list;
    }

    public List<MobileDTO> getAllMobliesByEngineAndOS(EngineEnum engineEnum, MobileOsEnum mobileOsEnum) throws EngineException{
        List<MobileDTO> list = new ArrayList<>();

        if(engineEnum.value() == EngineEnum.ENGINE_ETE.value()){
            //从ete引擎查询设备信息
            List<MobileDTO> eteMobiles = eteMobilePipe.queryMobilesByOS(mobileOsEnum);
            if(eteMobiles != null){
                list.addAll(eteMobiles);
            }
        }else if(engineEnum.value() == EngineEnum.ENGINE_MTCE.value()){
            //从mtc 引擎查询设备信息
            List<MobileDTO> mtcMobiles = mtcMobilePipe.queryMobilesByOS(mobileOsEnum);
            if (mtcMobiles != null){
                list.addAll(mtcMobiles);
            }
        }else {
            //从所有引擎查询设备信息
            list.addAll(getAllEngineMobiles());
        }
        return list;
    }

    public List<MobileDTO> getAllEngineMobiles(){

        List<MobileDTO> list = new ArrayList<>();
        //先从ete引擎查询设备信息
        try{
            List<MobileDTO> eteMobiles = eteMobilePipe.queryMobiles();
            if(eteMobiles != null){
                list.addAll(eteMobiles);
            }
        }catch (EngineException ee){
            LOGGER.error("[mobile engine] query mobiles form ete has a error", ee);
        }

        //从mtc 引擎查询设备信息
        try{
            List<MobileDTO> mtcMobiles = mtcMobilePipe.queryMobiles();
            if(mtcMobiles != null){
                list.addAll(mtcMobiles);
            }
        }catch (EngineException ee){
            LOGGER.error("[mobile engine] query mobiles form mtce has a error", ee);
        }
        return list;
    }
}
