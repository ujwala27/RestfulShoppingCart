package com.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA. User: Ujwala Chintala Date: 10/17/14 Time: 9:12 PM To
 * change this template use File | Settings | File Templates.
 */
@Transactional
@Repository
public class GenericDao<T> {

    @Inject
    private static SessionFactory sessionFactory;

    private Session session;

    private Class<? extends T> clazz;

    public GenericDao() {
    }

    public void setClassType(Class<T> clazz) {
        this.clazz = clazz;
    }

	/*
	 * private GenericDao(Class<T> clazz) { this.clazz = clazz; }
	 */

    public List<T> findAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(this.clazz);
        return criteria.list();
    }

    public int insert(T t) {
        Session session = getSession();
        return (Integer) session.save(t);
    }

    public void delete(int id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        T application = getById(id);
        session.delete(application);
        session.flush();
        tx.commit();
    }

    public T update(T t) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Object object = session.merge(t);
        transaction.commit();
        session.flush();
        return (T) object;

    }

    public int save(T t) {
        Session session = getSession();
        return (Integer) session.save(t);
    }

    public T getById(int id) {
        Session session = getSession();
        return (T) session.get(clazz, id);
    }

    public List<T> getByName(String sql, String parameter, String column) {
        Session session = getSession();
        Query query = session.createSQLQuery(sql + ":" + column)
                .addEntity(clazz).setParameter(column, parameter);
        return query.list();
    }

    public List<T> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(this.clazz);
        return criteria.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        if (this.sessionFactory == null) {
            this.sessionFactory = sessionFactory;
        }
    }

    public Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

   /* public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(GenericDao.class);
    }*/

}
