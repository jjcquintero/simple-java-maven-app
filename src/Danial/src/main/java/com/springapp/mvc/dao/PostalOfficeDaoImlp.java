package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PostalOfficeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class PostalOfficeDaoImlp implements PostalOfficeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(PostalOfficeEntity postalOfficeEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(postalOfficeEntity);

    }

    @Override
    public void edit(PostalOfficeEntity postalOfficeEntity) {
        sessionFactory.getCurrentSession().update(postalOfficeEntity);

    }


    @Override
    public void delete(String companyRegNo) {
        sessionFactory.getCurrentSession().delete(getPostalOffice(companyRegNo));

    }

    @Override
    public PostalOfficeEntity getPostalOffice(String companyRegNo) {
        return (PostalOfficeEntity)sessionFactory.getCurrentSession().get(PostalOfficeEntity.class, companyRegNo);

    }

    @Override
    public List getAllPostalOffice() {
        return sessionFactory.getCurrentSession().createQuery("from PostalOfficeEntity ").list();

    }
}
