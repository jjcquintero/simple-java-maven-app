package com.springapp.mvc.dao;

import com.springapp.mvc.domain.AuthenticationEntity;

import java.util.List;

/**
 * Created by prakhash on 25/08/15.
 */
public interface AuthenticationDao {

    void insert(AuthenticationEntity authenticationEntity);
    public AuthenticationEntity getUserDetails(String userName);
    void edit(AuthenticationEntity authenticationEntity);
    void delete(String userName);
    List getAllUsers();
}
