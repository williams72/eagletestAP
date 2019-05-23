package com.dilatoit.eagletest.service.impl;

import com.dilatoit.eagletest.enums.ExceptionEnum;
import com.dilatoit.eagletest.enums.UserStatus;
import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.exception.ex.NullObjectException;
import com.dilatoit.eagletest.exception.ex.ParameterException;
import com.dilatoit.eagletest.model.EtRole;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.model.EtUserConfig;
import com.dilatoit.eagletest.service.RoleService;
import com.dilatoit.eagletest.service.UserService;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import com.dilatoit.eagletest.util.SecurityTools;
import com.dilatoit.eagletest.util.modelquery.UserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2016/11/12.
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseService<EtUser> implements UserService {
    @Autowired
    private RoleService roleService;

    public void saveUser(EtUser user) throws DataBaseException {
        this.baseDAO.save(user);
    }

    public List<EtUser> queryAll() throws DataBaseException {
        return this.baseDAO.queryAll(com.dilatoit.eagletest.model.EtUser.class);
    }

    public void deleteUser(EtUser user) throws DataBaseException {
        this.baseDAO.delete(user);
    }

    public void updateUser(EtUser user) throws DataBaseException {
        this.baseDAO.update(user);
    }

    public void disableUser(Integer userId) throws DataBaseException {
        EtUser user = this.queryUserById(userId);
        if (user != null) {
            user.setStatus(UserStatus.DISABLE.value());
            this.updateUser(user);
        } else {
            //throw a exception
            System.out.println("用户不存在");
        }
    }

    public void enableUser(Integer userId) throws DataBaseException {
        EtUser user = this.queryUserById(userId);
        if (user != null) {
            user.setStatus(UserStatus.ENABLE.value());
            this.updateUser(user);
        } else {
            //throw a exception
        }
    }

    public void deleteUser(Integer userId) throws DataBaseException, BusinessException {
        EtUser user = queryUserById(userId);
        if (user != null) {
            deleteUser(user);
        } else {
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        }
    }

    public EtUser queryUserById(Integer userId) throws DataBaseException {
        try {
            return (EtUser) this.baseDAO.queryById(com.dilatoit.eagletest.model.EtUser.class, userId);
        } catch (Exception e) {
            throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public void addRole(Integer userId, Integer roleId) throws DataBaseException, BusinessException {
        EtUser user = this.queryUserById(userId);
        if (user != null) {
            try {
                EtRole role = roleService.queryRoleById(roleId);
                //role.setId(roleId);
                user.getEtRoles().add(role);
                this.updateUser(user);
            } catch (Exception e) {
                throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
        } else {
            throw new BusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    public void removeRole(Integer userId, Integer roleId) throws DataBaseException, BusinessException {
        EtUser user = this.queryUserById(userId);
        if (user != null) {
            try {
                EtRole role = roleService.queryRoleById(roleId);
                user.getEtRoles().remove(role);
                this.updateUser(user);
            } catch (Exception e) {
                throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
            }
        } else {
            throw new BusinessException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    public EtUser isExistById(Integer userId) throws DataBaseException {
        return this.queryUserById(userId);
    }

    public EtUser isExistByUsername(String username) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("username", username, Conditions.Operator.EQUAL);
        return this.queryUserByConditions(conditions);
    }

    public EtUser isExistByEmail(String email) throws DataBaseException {
        Conditions conditions = new Conditions();
        conditions.addCondition("email", email, Conditions.Operator.EQUAL);
        return this.queryUserByConditions(conditions);
    }

    public EtUser isExistByUsernameOrEmail(String usernameOrEmail) throws DataBaseException {
        //query is exist by username
        EtUser user = this.isExistByUsername(usernameOrEmail);
        if (user != null) {
            return user;
        }
        //query is exist by email
        user = this.isExistByEmail(usernameOrEmail);
        if (user != null) {
            return user;
        }
        return null;
    }


    public EtUser loginByUsername(String username, String password) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("username", username, Conditions.Operator.EQUAL);
        String md5Password = SecurityTools.toMd5(password);
        EtUser user = null;
        try {
            user = this.queryUserByConditions(conditions);
        } catch (DataBaseException dbe) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }

        if (user == null) {
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        } else if (md5Password.equals(user.getPassword())) {
            return user;
        } else {
            throw new BusinessException(ExceptionEnum.USER_AUTHENTICATION_ERROR);
        }
    }

    public EtUser loginByEmail(String email, String password) throws BusinessException {
        Conditions conditions = new Conditions();
        conditions.addCondition("email", email, Conditions.Operator.EQUAL);
        String md5Password = SecurityTools.toMd5(password);
        EtUser user = null;
        try {
            user = this.queryUserByConditions(conditions);
        } catch (DataBaseException dbe) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        if (user == null) {
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        } else if (md5Password.equals(user.getPassword())) {
            return user;
        } else {
            throw new BusinessException(ExceptionEnum.USER_AUTHENTICATION_ERROR);
        }
    }

    public EtUser loginByUsernameOrEmail(String usernameOrEmail, String password) throws BusinessException {
        EtUser user = null;

        try {
            user = loginByUsername(usernameOrEmail, password);
            return user;
        } catch (BusinessException be) {

        }
        try {
            user = loginByEmail(usernameOrEmail, password);
            return user;
        } catch (BusinessException be) {

        }
        //两种登录都没有通过
        throw new BusinessException(ExceptionEnum.USER_AUTHENTICATION_ERROR);
    }

    public EtUser queryUserByConditions(Conditions conditions) throws DataBaseException {
        try {
            List<EtUser> list = this.baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtUser.class, conditions);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Exception e) {
            throw new DataBaseException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
        return null;
    }

    public void page(DataPage<EtUser> page) throws DataBaseException {
        Conditions conditions = new Conditions();
        page(page, conditions);
    }

    public void page(DataPage<EtUser> page, Conditions conditions) throws DataBaseException {
        try {
            baseDAO.page(page, com.dilatoit.eagletest.model.EtUser.class, conditions);
        } catch (Exception e) {
            throw new DataBaseException(ExceptionEnum.DB_QUERY_PAGE_ERROR);
        }
    }

    public EtUser addUser(EtUser user) throws DataBaseException, BusinessException {
        if (user != null) {
            if (isExistByUsername(user.getUsername()) != null) {
                throw new BusinessException(ExceptionEnum.USER_NAME_IS_USED);
            }
            if (isExistByEmail(user.getEmail()) != null) {
                throw new BusinessException(ExceptionEnum.USER_EMAIL_IS_USED);
            }

            Date addDate = new Date();
            user.setCreatetime(addDate);
            user.setLastlogintime(null);
            user.setLastmodifiedtime(addDate);
            EtUserConfig config = new EtUserConfig();
            //设置用户初始配置
            // 00 代表用户刚刚创建还没有访问过任何项目
            config.setLastViewProject("00");

            user.setEtUserConfig(config);
            user.setStatus(UserStatus.ENABLE.value());
            user.setRealname("还没有写名字哦");

            //security password to md5
            user.setPassword(SecurityTools.toMd5(user.getPassword()));
            //add role
            EtRole role = roleService.queryRoleById(2);
            user.getEtRoles().add(role);

            saveUser(user);

            //return the new user
            user = isExistByUsername(user.getUsername());
            return user;

        } else {
            throw new NullObjectException(ExceptionEnum.NUll_OBJECT_ERROR);
        }
    }

    public void changePassword(Integer userId, String oldPassowrd, String newPassword) throws BusinessException {
        try {
            EtUser user = this.queryUserById(userId);
            if (user != null) {
                if (user.getPassword().equals(SecurityTools.toMd5(oldPassowrd))) {
                    user.setPassword(SecurityTools.toMd5(newPassword));
                    updateUser(user);
                } else {
                    throw new BusinessException(ExceptionEnum.BUSINESS_OLD_PWD_ERROR);
                }
            } else {
                throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
            }
        } catch (DataBaseException dbe) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }


    }

    public void changePassword(Integer userId, String newPassword) throws BusinessException {
        try {
            EtUser user = this.queryUserById(userId);
            if (user != null) {
                user.setPassword(SecurityTools.toMd5(newPassword));
                updateUser(user);
            } else {
                throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
            }
        } catch (DataBaseException dbe) {
            throw new BusinessException(ExceptionEnum.DB_QUERY_RESULT_ERROR);
        }
    }

    public EtUser login(String account, String password) throws BusinessException {
        EtUser user = null;
        // 1、检查用户是否存在
        try {
            user = isExistByUsernameOrEmail(account);
        } catch (DataBaseException dbe) {
            /************************************/
            //待处理异常
            //************************************/
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        }

        if (user != null) {
            //检查用户是否被禁止登陆
            if (user.getStatus() == UserStatus.DISABLE.value()) {
                throw new BusinessException(ExceptionEnum.USER_DISABLE);
            }
            //2、检查密码是否正确
            String md5Pwd = SecurityTools.toMd5(password);
            if (user != null && md5Pwd.equals(user.getPassword())) {
                //记录用户最后登录时间
                user.setLastlogintime(new Date());
                try {
                    updateUser(user);
                } catch (DataBaseException e) {
                    e.printStackTrace();
                    throw new BusinessException(ExceptionEnum.DB_UPDATE_RESULT_ERROR);
                }
                return user;
            } else {
                throw new BusinessException(ExceptionEnum.USER_PASSWORD_ERROR);
            }
        } else {
            throw new BusinessException(ExceptionEnum.USER_IS_NOT_EXIST);
        }
    }

    public List<EtUser> get(String querys) throws DataBaseException, BusinessException {
        if (StringUtils.isNotBlank(querys)) {
            String[] params = querys.split("&");
            Conditions conditions = new Conditions();
            for (String param : params) {
                System.out.println("param = " + param);
                if (StringUtils.isNotBlank(param) && param.contains("=")) {
                    String kv[] = param.split("=");
                    if (UserQuery.contains(kv[0])) {
                        conditions.addCondition(kv[0], kv[1], Conditions.Operator.EQUAL);
                    } else {
                        throw new ParameterException(ExceptionEnum.PARAM_ERROR);
                    }
                } else {
                    throw new ParameterException(ExceptionEnum.PARAM_ERROR);
                }
            }
            return this.baseDAO.queryByConditions(com.dilatoit.eagletest.model.EtUser.class, conditions);
        }
        return null;
    }
}
