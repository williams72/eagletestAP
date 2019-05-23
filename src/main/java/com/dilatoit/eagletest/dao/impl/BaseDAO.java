package com.dilatoit.eagletest.dao.impl;

import java.io.Serializable;

import java.util.List;
import javax.annotation.Resource;

import com.dilatoit.eagletest.dao.IDAO;
import com.dilatoit.eagletest.exception.ex.DataBaseException;

import com.dilatoit.eagletest.util.Conditions;
import com.dilatoit.eagletest.util.DataPage;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository(value = "baseDAO")
public class BaseDAO<T> implements IDAO<T> {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public Integer save(T bean) throws DataBaseException {
        return (Integer) hibernateTemplate.save(bean);
    }

    public void delete(T bean) throws DataBaseException {
        hibernateTemplate.delete(bean);
    }

    public void update(T bean) throws DataBaseException {
        hibernateTemplate.update(bean);
    }

    public void saveOrUpdate(T bean) throws DataBaseException {
        hibernateTemplate.saveOrUpdate(bean);
    }

    public Object queryById(Class<T> clazz, Serializable id) throws DataBaseException {
        return hibernateTemplate.get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> queryAll(Class<T> clazz) throws DataBaseException{
        String hql = "from " + clazz.getName();
        return (List<T>) hibernateTemplate.find(hql);
    }

    @SuppressWarnings("unchecked")
    public Object queryByName(Class<T> clazz, String queryName, String value) throws DataBaseException{
        Object obj = null;
        String hql = "from " + clazz.getName() + " bean where bean." + queryName
                + " = ?";
        List<T> list = (List<T>) hibernateTemplate.find(hql, value);
        if (list != null && list.size() > 0) {
            obj = list.get(0);
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    public List<T> queryByHql(String hql, Object[] params) throws DataBaseException {
        return (List<T>) hibernateTemplate.find(hql, params);
    }

    @SuppressWarnings("unchecked")
    public DataPage<T> queryByPage(String hql, Object[] params, int offset, int limit) throws DataBaseException {
        DataPage<T> dataPage = new DataPage<>();
        List<T> result = hibernateTemplate.execute(session -> {
           Query query = session.createQuery(hql);
           query.setFirstResult(offset > 0 ? (offset - 1) * limit : 0);
           query.setMaxResults(limit);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i, params[i]);
                }
            }
            return query.list();
        });
        dataPage.setOffset(offset);
        dataPage.setLimit(limit);
        dataPage.setData(result);
        dataPage.setRows(countTotalRows(hql, params));
        return dataPage;
    }

    public int countTotalRows(String hql, Object[] params) throws DataBaseException {
        List<T> list = queryByHql(hql, params);
        if(list != null){
            return list.size();
        }else{
            return 0;
        }
    }

    public List executeNativeSqlQuery(String sql, Object[] params) throws DataBaseException {
        return  hibernateTemplate.execute(session -> {
            Query query = session.createNativeQuery(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]);
                }
            }
            return query.list();
        });
    }

    @Deprecated
    public int page(final DataPage<T> page, Class<T> clazz, Conditions conditions) throws DataBaseException {
        Conditions.WhereAndValues wv = conditions.createWhereAndValues();
        final String hql = "from " + clazz.getName() + wv.getWhere() + conditions.createOrderByString();
        final Object[] values = wv.getValues();
        List<T> result = (List<T>) hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session)
                    throws HibernateException{
                Query query = session.createQuery(hql);
                query.setFirstResult(page.start());
                query.setMaxResults(page.getLimit());
                int index = 0;
                for (Object obj : values) {
                    query.setParameter(index++, obj);
                }
                return query.list();
            }
        });
        // 设置总行数
        page.setRows(this.countRows(clazz, conditions));
        page.setData(result);
        return 1;
    }
    @Deprecated
    public int countRows(Class<T> clazz, Conditions conditions) throws DataBaseException {
        List<T> list = this.queryByConditions(clazz, conditions);
        if(list != null){
            return list.size();
        }else{
            return 0;
        }
    }
    @Deprecated
    public List<T> queryByConditions(Class<T> clazz, Conditions conditions) throws DataBaseException {
        Conditions.WhereAndValues wv = conditions.createWhereAndValues();
        final String hql = "from " + clazz.getName() + wv.getWhere() + conditions.createOrderByString();
        System.out.println("hql = " + hql);
        final Object[] values = wv.getValues();

        @SuppressWarnings({"deprecation", "unchecked"})
        List<T> result = (List<T>) hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException{
                Query query = session.createQuery(hql).setCacheable(true);
                int index = 0;
                for (Object obj : values) {
                    query.setParameter(index++, obj);
                }
                return query.list();
            }
        });
        if(result != null && result.size() <= 0){
            return null;
        }
        return result;
    }
    @Deprecated
    public List<T> queryBySqlInId(Class clazz, String sql, Object[] value) throws DataBaseException{
        final String hql = "from " + clazz.getName() + sql;
        System.out.println("hql = " + hql);
        @SuppressWarnings({"deprecation", "unchecked"})
        List<T> result = (List<T>) hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException{
                Query query = session.createQuery(hql).setCacheable(true);
                query.setParameterList("id", value);
                return query.list();
            }
        });
        if(result != null && result.size() <= 0){
            return null;
        }
        return result;

    }

    public HibernateTemplate getHibernateTemplate() throws DataBaseException {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) throws DataBaseException {
        this.hibernateTemplate = hibernateTemplate;
    }

}
