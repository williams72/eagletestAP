package com.dilatoit.engine.engines.mtc.data.adapter;

import com.dilatoit.engine.dto.MobileDTO;
import com.dilatoit.engine.enums.MobileStatusEnum;
import com.dilatoit.engine.enums.MobileTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xueshan.wei on 4/10/2017.
 */
public class MobileTranslate {
    public static MobileDTO translate(){
        return null;
    }

    public static List<MobileDTO> translateList(List mobiles){
        List<MobileDTO> mobileBOList = new ArrayList<MobileDTO>();
        for(Object mobile : mobiles){
            mobileBOList.add(MobileTranslate.translate(mobile));
        }
        return mobileBOList;
    }

    private static MobileDTO translate(Object mobile){
        Map temp = (Map) mobile;
        MobileDTO mobileBO = new MobileDTO();
        mobileBO.setName((String) temp.get("name"));
        int mobileType = Integer.parseInt((String)temp.get("mobile_type"));
        if(mobileType == 0){
            mobileBO.setMobileType(MobileTypeEnum.ANDROID.value());
        }else{
            mobileBO.setMobileType(MobileTypeEnum.IOS.value());
        }
        mobileBO.setSerialno((String) temp.get("serial_number"));
        mobileBO.setMacAddress((String) temp.get("macname"));
        mobileBO.setWorkIp((String) temp.get("worker_ip"));
        mobileBO.setBrand((String) temp.get("brand"));
        mobileBO.setModel((String) temp.get("model"));
        mobileBO.setOs((String) temp.get("os"));
        mobileBO.setSdkVersion((String) temp.get("sdk_version"));
        mobileBO.setWidth((String) temp.get("width"));
        mobileBO.setHeight((String) temp.get("height"));
        mobileBO.setSimStatus(Integer.parseInt((String) temp.get("sim_status")));
        mobileBO.setBatteryLevel(Integer.parseInt((String) temp.get("battery_level")));

        String status = (String) temp.get("status");
        if("空闲".equals(status)){
            mobileBO.setStatus(MobileStatusEnum.ONLINE.value());
            mobileBO.setBusy(false);
        }else {
            mobileBO.setBusy(true);
            if(temp.containsKey("taskType")){
                int taskType = ((Double) temp.get("taskType")).intValue();
                if(taskType == 0){
                    //执行任务中
                    mobileBO.setStatus(MobileStatusEnum.WORKING_TASK.value());
                }else {
                    mobileBO.setStatus(MobileStatusEnum.WORKING_REAL.value());
                }
            }
        }
        mobileBO.setScreenshotUrl((String) temp.get("screen_shot_url"));
        mobileBO.setRebootStatus(Integer.parseInt((String) temp.get("reboot_status")));
        mobileBO.setExtraInfo((String) temp.get("extra_info"));
        /*DateUtils.parseDate()
        mobileBO.setUpdatedTime((Date.) temp.get("updated"));
        */
        return mobileBO;
    }
}
