package com.dilatoit.eagletest.dto.translate;

import com.dilatoit.eagletest.dto.UserDTO;
import com.dilatoit.eagletest.model.EtUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueshan.wei on 5/11/2017.
 */
public class UserDTOTranslate {
    public static UserDTO translate(EtUser user){
        UserDTO userDTO = null;
        if(user != null){
            userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setAvatars(user.getAvatars());
            userDTO.setEmail(user.getEmail());
            userDTO.setRealname(user.getRealname());
            userDTO.setStatus(user.getStatus());
            userDTO.setUsername(user.getUsername());
            userDTO.setCreatetime(user.getCreatetime() != null ? user.getCreatetime().getTime() : 0L);
            userDTO.setLastlogintime(user.getLastlogintime() != null ? user.getLastlogintime().getTime() : 0L);
            userDTO.setLastmodifedtime(user.getLastmodifiedtime() != null ? user.getLastmodifiedtime().getTime() : 0L);
        }
        return userDTO;
    }

    public static List<UserDTO> translateList(List<EtUser> objs){
        List<UserDTO> list = null;
        if(objs != null){
            list = new ArrayList<UserDTO>();
            for(EtUser obj : objs){
                list.add(UserDTOTranslate.translate(obj));
            }
        }
        return list;
    }
}
