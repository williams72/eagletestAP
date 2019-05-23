package com.dilatoit.eagletest.service;

import com.dilatoit.eagletest.exception.ex.BusinessException;
import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.model.EtUser;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.util.List;

/**
 * Created by beishan on 2016/11/12.
 */
public interface UserService {
    /**
     * query user by querys
     * @param querys one or more query conditions
     * @return
     * @throws DataBaseException
     */
    List<EtUser> get(String querys) throws DataBaseException, BusinessException;
    /**
     * user login
     * @param account
     * @param password
     * @return user
     * @throws BusinessException
     */
    public EtUser login(String account, String password) throws BusinessException;
    /**
     * save a user entity
     * @param user
     * @throws Exception
     */
    public void saveUser(EtUser user) throws DataBaseException;

    /**
     * query all user
     * @return
     * @throws Exception
     */
    public List<EtUser> queryAll() throws DataBaseException;

    /**
     * delete a user
     * @param user
     * @throws Exception
     */
    public void deleteUser(EtUser user) throws DataBaseException;

    /**
     * update a user
     * @param user
     * @throws Exception
     */
    public void updateUser(EtUser user) throws DataBaseException;

    /**
     * disable a user by userId
     * @param userId
     * @throws Exception
     */
    public void disableUser(Integer userId) throws DataBaseException;

    /**
     * enable a user by userId
     * @param userId
     * @throws Exception
     */
    public void enableUser(Integer userId) throws DataBaseException;

    /**
     * query a user by userId
     * @param userId
     * @return
     * @throws Exception
     */
    public EtUser queryUserById(Integer userId) throws DataBaseException;

    /**
     * add a role
     * @param roleId
     * @param userId
     * @throws Exception
     */
    public void addRole(Integer userId, Integer roleId) throws DataBaseException, BusinessException;

    /**
     * remove a role
     * @param userId
     * @param roleId
     * @throws Exception
     */
    public void  removeRole(Integer userId, Integer roleId) throws DataBaseException, BusinessException;

    /**
     * query a user is exist by userId
     * @param userId
     * @return
     * @throws Exception
     */
    public EtUser isExistById(Integer userId) throws DataBaseException;

    /**
     * query a user is exist by username
     * @param username
     * @return
     * @throws Exception
     */
    public EtUser isExistByUsername(String username) throws DataBaseException;

    /**
     * query a user is exist by email
     * @param email
     * @return
     * @throws Exception
     */
    public EtUser isExistByEmail(String email) throws DataBaseException;

    /**
     * query a user is exist by username or email
     * @param usernameOrEmail
     * @return
     * @throws Exception
     */
    public EtUser isExistByUsernameOrEmail(String usernameOrEmail) throws DataBaseException;

    /**
     * login by username
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public EtUser loginByUsername(String username, String password) throws BusinessException;

    /**
     * login by email
     * @param email
     * @param password
     * @return
     * @throws Exception
     */
    public EtUser loginByEmail(String email, String password) throws BusinessException;

    /**
     * login by username or email
     * @param usernameOrEmail
     * @param password
     * @return
     * @throws Exception
     */
    public EtUser loginByUsernameOrEmail(String usernameOrEmail, String password) throws BusinessException;

    /**
     * query user by conditions
     * @param conditions
     * @return
     * @throws Exception
     */
    public EtUser queryUserByConditions(Conditions conditions) throws DataBaseException;

    /**
     * query user by page
     * @param page
     * @throws DataBaseException
     */
    public void page(DataPage<EtUser> page) throws DataBaseException;

    /**
     * query user by page and conditions
     * @param page
     * @param conditions
     * @throws DataBaseException
     */
    public void page(DataPage<EtUser> page, Conditions conditions) throws DataBaseException;

    /**
     * add user
     * @param user
     * @return
     * @throws DataBaseException
     * @throws BusinessException
     */
    public EtUser addUser(EtUser user) throws DataBaseException, BusinessException;

    /**
     * change the password
     * @param userId
     * @param oldPassowrd
     * @param newPassword
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void changePassword(Integer userId, String oldPassowrd, String newPassword) throws BusinessException;

    /**
     * change the password by admin
     * @param userId
     * @param newPassword
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void changePassword(Integer userId, String newPassword) throws BusinessException;

    /**
     * delete a user by userId
     * @param userId
     * @throws DataBaseException
     * @throws BusinessException
     */
    public void deleteUser(Integer userId) throws DataBaseException, BusinessException;
}
