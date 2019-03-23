package com.springapp.mvc.dao;

import com.springapp.mvc.domain.BusinessOfficeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class BusinessOfficeDaoImpl implements BusinessOfficeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(BusinessOfficeEntity businessOfficeEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(businessOfficeEntity);

    }

    @Override
    public void edit(BusinessOfficeEntity businessOfficeEntity) {
        sessionFactory.getCurrentSession().update(businessOfficeEntity);

    }


    @Override
    public void delete(String companyRegNo) {
        sessionFactory.getCurrentSession().delete(getBusinessOffice(companyRegNo));

    }

    @Override
    public BusinessOfficeEntity getBusinessOffice(String companyRegNo) {
        return (BusinessOfficeEntity)sessionFactory.getCurrentSession().get(BusinessOfficeEntity.class, companyRegNo);

    }

    @Override
    public List getAllBusinessOffice() {
        return sessionFactory.getCurrentSession().createQuery("from BusinessOfficeEntity ").list();

    }
}
