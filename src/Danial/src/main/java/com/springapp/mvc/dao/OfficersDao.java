package com.springapp.mvc.dao;

import com.springapp.mvc.domain.OfficersEntity;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public interface OfficersDao {
    void insert(OfficersEntity officersEntity);
    void edit(OfficersEntity officersEntity);
    void delete(int officerID);
    OfficersEntity getOfficer(int officerID);
    List getAllOfficers();
}
