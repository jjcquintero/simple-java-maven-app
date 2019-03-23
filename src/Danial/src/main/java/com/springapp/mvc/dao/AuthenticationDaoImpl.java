package com.springapp.mvc.dao;

import com.springapp.mvc.domain.AuthenticationEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by prakhash on 25/08/15.
 */
@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

    @Autowired
    private SessionFactory sessionFactory;


    public AuthenticationDaoImpl() {

    }

    @Override
    public void insert(AuthenticationEntity authenticationEntity) {
    sessionFactory.getCurrentSession().saveOrUpdate(authenticationEntity);
    }

    @Override
    public AuthenticationEntity getUserDetails(String userName) {

        AuthenticationEntity authenticationEntity=(AuthenticationEntity)sessionFactory.getCurrentSession().get(AuthenticationEntity.class, userName);
        return authenticationEntity;


    }

    @Override
    public void edit(AuthenticationEntity authenticationEntity) {
        sessionFactory.getCurrentSession().update(authenticationEntity);
    }

    @Override
    public void delete(String userName) {
        sessionFactory.getCurrentSession().delete(getUserDetails(userName));

    }

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from AuthenticationEntity").list();
    }


}
