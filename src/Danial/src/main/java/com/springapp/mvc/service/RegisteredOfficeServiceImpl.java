package com.springapp.mvc.service;

import com.springapp.mvc.dao.RegisteredOfficeDao;
import com.springapp.mvc.domain.RegisteredOfficeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 8/31/15.
 */
public class RegisteredOfficeServiceImpl implements RegisteredOfficeService {
    @Autowired
    private RegisteredOfficeDao registeredOfficeDao;

    @Override
    @Transactional

    public void insert(RegisteredOfficeEntity registeredOfficeEntity) {
        registeredOfficeDao.insert(registeredOfficeEntity);
    }

    @Override
    @Transactional

    public void edit(RegisteredOfficeEntity registeredOfficeEntity) {
        registeredOfficeDao.edit(registeredOfficeEntity);
    }

    @Override
    @Transactional

    public void delete(String companyRegNo) {
        registeredOfficeDao.delete(companyRegNo);
    }

    @Override
    @Transactional

    public RegisteredOfficeEntity getRegisteredOffice(String companyRegNo) {
        return registeredOfficeDao.getRegisteredOffice(companyRegNo);
    }

    @Override
    @Transactional

    public List getAllRegisteredOffice() {
        return registeredOfficeDao.getAllRegisteredOffice();
    }
}
