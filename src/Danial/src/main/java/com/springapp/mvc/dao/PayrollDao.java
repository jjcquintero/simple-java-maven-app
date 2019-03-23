package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PayrollEntity;

import java.util.List;

/**
 * Created by bruntha on 12/14/15.
 */
public interface PayrollDao {
    void insert(PayrollEntity payrollEntity);
    void edit(PayrollEntity payrollEntity);
    void delete(String comRef);
    PayrollEntity getPayroll(String comRef);
    List getAllPayrolls();
}
