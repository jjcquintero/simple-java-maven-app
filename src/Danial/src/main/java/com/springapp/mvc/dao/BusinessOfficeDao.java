package com.springapp.mvc.dao;

import com.springapp.mvc.domain.BusinessOfficeEntity;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public interface BusinessOfficeDao {
    void insert(BusinessOfficeEntity businessOfficeEntity);
    void edit(BusinessOfficeEntity businessOfficeEntity);
    void delete(String companyRegNo);
    BusinessOfficeEntity getBusinessOffice(String companyRegNo);
    List getAllBusinessOffice();
}
