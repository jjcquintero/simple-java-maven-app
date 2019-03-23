package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MarketingMainEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bruntha on 8/17/15.
 */
@Repository
public class MarketingMainDaoImpl implements MarketingMainDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(MarketingMainEntity marketingMainEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(marketingMainEntity);
    }

    @Override
    public void edit(MarketingMainEntity marketingMainEntity) {
        sessionFactory.getCurrentSession().update(marketingMainEntity);

    }

    @Override
    public void delete(String companyRegNo) {
        sessionFactory.getCurrentSession().delete(getMarketingMain(companyRegNo));

    }

    @Override
    public MarketingMainEntity getMarketingMain(String companyRegNo) {
        return (MarketingMainEntity)sessionFactory.getCurrentSession().get(MarketingMainEntity.class, companyRegNo);

    }

    @Override
    public List getAllMarketingMain() {
        return sessionFactory.getCurrentSession().createQuery("from MarketingMainEntity").list();

    }
}
