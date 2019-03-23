package com.springapp.mvc.service;

import com.springapp.mvc.dao.PayrollDao;
import com.springapp.mvc.domain.PayrollEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 12/14/15.
 */
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollDao payrollDao;

    @Override
    @Transactional
    public void insert(PayrollEntity payrollEntity) {
        payrollDao.insert(payrollEntity);

    }

    @Override
    @Transactional
    public void edit(PayrollEntity payrollEntity) {
        payrollDao.edit(payrollEntity);

    }

    @Override
    @Transactional
    public void delete(String comRef) {
        payrollDao.delete(comRef);

    }

    @Override
    @Transactional
    public PayrollEntity getPayroll(String comRef) {
        return payrollDao.getPayroll(comRef);

    }

    @Override
    @Transactional
    public List getAllPayrolls() {
        return payrollDao.getAllPayrolls();

    }
}
