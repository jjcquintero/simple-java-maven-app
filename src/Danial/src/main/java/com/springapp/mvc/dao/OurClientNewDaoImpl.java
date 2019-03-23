package com.springapp.mvc.dao;

import com.springapp.mvc.domain.OurClientsNewEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class OurClientNewDaoImpl implements OurClientNewDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(OurClientsNewEntity ourClientsNewEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(ourClientsNewEntity);

    }

    @Override
    public void edit(OurClientsNewEntity ourClientsNewEntity) {
        sessionFactory.getCurrentSession().update(ourClientsNewEntity);

    }

    @Override
    public void delete(String companyRegNo) {
        sessionFactory.getCurrentSession().delete(getOurClientNew(companyRegNo));

    }

    @Override
    public OurClientsNewEntity getOurClientNew(String companyRegNo) {
        return (OurClientsNewEntity)sessionFactory.getCurrentSession().get(OurClientsNewEntity.class, companyRegNo);

    }

    @Override
    public List getAllOurClientNew(String tradingNameAtLocation) {
        return sessionFactory.getCurrentSession().createQuery("from OurClientsNewEntity as client " +
                "where client.companyName like :companyName").setParameter("companyName","%"+tradingNameAtLocation+"%").list();

    }

    @Override
    public List getAllOurClientNew() {
        return sessionFactory.getCurrentSession().createQuery("from OurClientsNewEntity").list();

    }

}
