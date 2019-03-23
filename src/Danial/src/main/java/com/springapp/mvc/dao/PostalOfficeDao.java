package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PostalOfficeEntity;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public interface PostalOfficeDao {
    void insert(PostalOfficeEntity postalOfficeEntity);
    void edit(PostalOfficeEntity postalOfficeEntity);
    void delete(String companyRegNo);
    PostalOfficeEntity getPostalOffice(String companyRegNo);
    List getAllPostalOffice();
}
