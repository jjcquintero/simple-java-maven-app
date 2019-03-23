package com.springapp.mvc.service;

import com.springapp.mvc.dao.PostalOfficeDao;
import com.springapp.mvc.domain.PostalOfficeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class PostalOfficeServiceImpl implements PostalOfficeService {

    @Autowired
    private PostalOfficeDao postalOfficeDao;

    @Override
    @Transactional
    public void insert(PostalOfficeEntity postalOfficeEntity) {
        postalOfficeDao.insert(postalOfficeEntity);

    }

    @Override
    @Transactional

    public void edit(PostalOfficeEntity postalOfficeEntity) {
        postalOfficeDao.edit(postalOfficeEntity);

    }


    @Override
    @Transactional

    public void delete(String companyRegNo) {
        postalOfficeDao.delete(companyRegNo);

    }

    @Override
    @Transactional

    public PostalOfficeEntity getPostalOffice(String companyRegNo) {
        return postalOfficeDao.getPostalOffice(companyRegNo);

    }

    @Override
    @Transactional

    public List getAllPostalOffice() {
        return postalOfficeDao.getAllPostalOffice();

    }
}
