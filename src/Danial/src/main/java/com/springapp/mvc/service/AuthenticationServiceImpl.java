package com.springapp.mvc.service;

import com.springapp.mvc.dao.AuthenticationDao;
import com.springapp.mvc.domain.AuthenticationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by prakhash on 25/08/15.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationDao authenticationDao;

    @Override
    @Transactional
    public void insert(AuthenticationEntity authenticationEntity) {
        authenticationDao.insert(authenticationEntity);
    }

    @Override
    @Transactional
    public AuthenticationEntity getUserDetails(String userName) {
        return authenticationDao.getUserDetails(userName);
    }

    @Override
    @Transactional
    public void edit(AuthenticationEntity authenticationEntity) {
        AuthenticationEntity authenticationEntity1;
        authenticationDao.edit(authenticationEntity);
    }

    @Override
    @Transactional
    public void delete(String userName) {
        authenticationDao.delete(userName);

    }

    @Override
    @Transactional
    public List getAllUsers() {
        return authenticationDao.getAllUsers();
    }


}
