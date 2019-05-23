package com.dilatoit.eagletest.dao;

import com.dilatoit.eagletest.exception.ex.DataBaseException;
import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;

import java.io.Serializable;
import java.util.List;

public interface IDAO<T> {
	Integer save(T bean) throws DataBaseException;

	void delete(T bean) throws DataBaseException;

	void update(T bean) throws DataBaseException;

	void saveOrUpdate(T bean) throws DataBaseException;

	Object queryById(Class<T> clazz, Serializable id) throws DataBaseException;

	List<T> queryAll(Class<T> clazz) throws DataBaseException;

	Object queryByName(Class<T> clazz, String queryName, String value) throws DataBaseException;

	List<T> queryByHql(String hql, Object[] params) throws DataBaseException;

	DataPage<T> queryByPage(String hql, Object[] params, int offset, int rows)throws DataBaseException;

	int countTotalRows(String hql, Object[] params)throws DataBaseException;

	/**
	 * 执行原生查询SQL, 带参数
	 * @param sql
	 * @param params
	 * @return
	 * @throws DataBaseException
	 */
	List executeNativeSqlQuery(String sql, Object[] params) throws DataBaseException;

	List<T> queryByConditions(Class<T> clazz, Conditions conditions) throws DataBaseException;

	List<T> queryBySqlInId(Class clazz, String sql, Object[] value) throws DataBaseException;

	int page(final DataPage<T> page, Class<T> clazz, Conditions conditions) throws DataBaseException;

	int countRows(Class<T> clazz, Conditions conditions) throws DataBaseException;

}
