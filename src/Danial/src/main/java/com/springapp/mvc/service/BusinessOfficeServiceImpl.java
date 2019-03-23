package com.springapp.mvc.service;

import com.springapp.mvc.dao.BusinessOfficeDao;
import com.springapp.mvc.domain.BusinessOfficeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class BusinessOfficeServiceImpl implements BusinessOfficeService {

    @Autowired
    private BusinessOfficeDao businessOfficeDao;

    @Override
    @Transactional
    public void insert(BusinessOfficeEntity businessOfficeEntity) {
        businessOfficeDao.insert(businessOfficeEntity);

    }

    @Override
    @Transactional
    public void edit(BusinessOfficeEntity businessOfficeEntity) {
        businessOfficeDao.edit(businessOfficeEntity);

    }

    @Override
    @Transactional
    public void delete(String companyRegNo) {
        businessOfficeDao.delete(companyRegNo);

    }

    @Override
    @Transactional
    public BusinessOfficeEntity getBusinessOffice(String companyRegNo) {
        return businessOfficeDao.getBusinessOffice(companyRegNo);

    }

    @Override
    @Transactional
    public List getAllBusinessOffice() {
        return businessOfficeDao.getAllBusinessOffice();

    }
}
