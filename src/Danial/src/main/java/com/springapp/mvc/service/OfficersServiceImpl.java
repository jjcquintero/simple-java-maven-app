package com.springapp.mvc.service;

import com.springapp.mvc.dao.OfficersDao;
import com.springapp.mvc.domain.OfficersEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class OfficersServiceImpl implements OfficersService {
    @Autowired
    private OfficersDao officersDao;
    @Override
    public void insert(OfficersEntity officersEntity) {
        officersDao.insert(officersEntity);

    }

    @Override
    public void edit(OfficersEntity officersEntity) {
        officersDao.edit(officersEntity);

    }

    @Override
    public void delete(int officerID) {
        officersDao.delete(officerID);

    }

    @Override
    public OfficersEntity getOfficer(int officerID) {
        return officersDao.getOfficer(officerID);

    }

    @Override
    public List getAllOfficers() {
        return officersDao.getAllOfficers();

    }
}
