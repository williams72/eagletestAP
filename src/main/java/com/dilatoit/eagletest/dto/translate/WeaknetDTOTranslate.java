package com.dilatoit.eagletest.dto.translate;

import com.dilatoit.eagletest.dto.WeaknetDTO;
import com.dilatoit.eagletest.enums.common.ModelFiledBooleanEnum;
import com.dilatoit.eagletest.model.EtWeaknet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 4/19/2017.
 */
public class WeaknetDTOTranslate {
    /**
     * EtWeaknet 转换成 WeaknetDTO
     * @param weaknet
     * @return WeaknetDTO Object | null
     */
    public static WeaknetDTO translate(EtWeaknet weaknet){
        WeaknetDTO weaknetDTO = null;
        if(weaknet != null){
            weaknetDTO = new WeaknetDTO();
            weaknetDTO.setId(weaknet.getId());
            weaknetDTO.setDesc(weaknet.getDesc());
            weaknetDTO.setCreateTime(weaknet.getCreateTime().getTime());
            weaknetDTO.setLastModifyTime(weaknet.getModifyTime().getTime());
            weaknetDTO.setName(weaknet.getName());
            weaknetDTO.setParam(weaknet.getParam());
            weaknetDTO.setKey(weaknet.getKey());
            weaknetDTO.setEnable(weaknet.getEnable() == ModelFiledBooleanEnum.TRUE.value());
            weaknetDTO.setSysdefault(weaknet.getSystemDefault() == ModelFiledBooleanEnum.TRUE.value());
        }
        return weaknetDTO;
    }

    /**
     * 转换 List<EtWeaknet> to List<WeaknetDTO>
     * @param weaknets
     * @return List<WeaknetDTO> | null
     */
    public static List<WeaknetDTO> translateList(List<EtWeaknet> weaknets){
        List<WeaknetDTO> weaknetDTOList = null;
        if(weaknets != null){
            weaknetDTOList = new ArrayList<>();
            for(EtWeaknet log : weaknets){
                weaknetDTOList.add(WeaknetDTOTranslate.translate(log));
            }
        }
        return weaknetDTOList;
    }
}
