package com.dilatoit.eagletest.authority;


import com.dilatoit.eagletest.authority.util.AuthorityTools;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtResPer;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.service.impl.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by beishan on 2016/12/9.
 */
@Component
public class AuthorityVerify {
    @Autowired
    private ServiceManager serviceManager;

    public boolean hasPermission(String [] permissions, Integer userId) throws DataBaseException {
        System.out.println("has permission beg----------------------------------");
        if(permissions != null && permissions.length > 0){
            EtUser user = serviceManager.getUserService().queryUserById(userId);
            //得到该用户的所有权限
            Set<String> u_permissions = new HashSet<String>();
            for(EtRole role : user.getEtRoles()){
                for(EtResPer resPer : role.getResPers()){
                    u_permissions.add(resPer.getResourcePermission());
                }
            }

            for(String permission : permissions){
                //System.out.println(permission);
                //System.out.println("解析权限------------------");
                List<String> ps = AuthorityTools.parsePermission(permission);

                for(String p : ps){
                    System.out.println("当前检查权限：" + p);
                    if(!u_permissions.contains(p)){
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }
}
