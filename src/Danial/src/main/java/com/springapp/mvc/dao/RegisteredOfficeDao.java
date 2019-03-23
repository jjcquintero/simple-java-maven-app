package com.springapp.mvc.dao;

import com.springapp.mvc.domain.RegisteredOfficeEntity;

import java.util.List;

/**
 * Created by bruntha on 8/31/15.
 */
public interface RegisteredOfficeDao {
    void insert(RegisteredOfficeEntity registeredOfficeEntity);
    void edit(RegisteredOfficeEntity registeredOfficeEntity);
    void delete(String companyRegNo);
    RegisteredOfficeEntity getRegisteredOffice(String companyRegNo);
    List getAllRegisteredOffice();
}
