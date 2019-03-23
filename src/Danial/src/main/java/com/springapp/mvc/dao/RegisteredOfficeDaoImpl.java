package com.springapp.mvc.dao;

import com.springapp.mvc.domain.RegisteredOfficeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 8/31/15.
 */
public class RegisteredOfficeDaoImpl implements RegisteredOfficeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(RegisteredOfficeEntity registeredOfficeEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(registeredOfficeEntity);

    }

    @Override
    public void edit(RegisteredOfficeEntity registeredOfficeEntity) {
        sessionFactory.getCurrentSession().update(registeredOfficeEntity);

    }

    @Override
    public void delete(String companyRegNo) {
        sessionFactory.getCurrentSession().delete(getRegisteredOffice(companyRegNo));

    }

    @Override
    public RegisteredOfficeEntity getRegisteredOffice(String companyRegNo) {
        return (RegisteredOfficeEntity)sessionFactory.getCurrentSession().get(RegisteredOfficeEntity.class, companyRegNo);

    }

    @Override
    public List getAllRegisteredOffice() {
        return sessionFactory.getCurrentSession().createQuery("from RegisteredOfficeEntity").list();

    }
}
