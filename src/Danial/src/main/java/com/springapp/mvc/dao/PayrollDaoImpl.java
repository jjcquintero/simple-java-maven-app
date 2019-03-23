package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PayrollEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 12/14/15.
 */
public class PayrollDaoImpl implements PayrollDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(PayrollEntity payrollEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(payrollEntity);

    }

    @Override
    public void edit(PayrollEntity payrollEntity) {
        sessionFactory.getCurrentSession().update(payrollEntity);

    }

    @Override
    public void delete(String comRef) {
        sessionFactory.getCurrentSession().delete(getPayroll(comRef));

    }

    @Override
    public PayrollEntity getPayroll(String comRef) {
        return (PayrollEntity)sessionFactory.getCurrentSession().get(PayrollEntity.class, comRef);

    }

    @Override
    public List getAllPayrolls() {
        return sessionFactory.getCurrentSession().createQuery("from PayrollEntity ").list();

    }
}
