package com.springapp.mvc.dao;

import com.springapp.mvc.domain.OfficersEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class OfficersDaoImpl implements OfficersDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(OfficersEntity officersEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(officersEntity);

    }

    @Override
    public void edit(OfficersEntity officersEntity) {
        sessionFactory.getCurrentSession().update(officersEntity);

    }

    @Override
    public void delete(int officerID) {
        sessionFactory.getCurrentSession().delete(getOfficer(officerID));

    }

    @Override
    public OfficersEntity getOfficer(int officerID) {
        return (OfficersEntity)sessionFactory.getCurrentSession().get(OfficersEntity.class, officerID);

    }

    @Override
    public List getAllOfficers() {
        return sessionFactory.getCurrentSession().createQuery("from OfficersEntity").list();

    }
}
