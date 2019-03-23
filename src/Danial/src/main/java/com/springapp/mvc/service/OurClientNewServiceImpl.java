package com.springapp.mvc.service;

import com.springapp.mvc.dao.OurClientNewDao;
import com.springapp.mvc.domain.OurClientsNewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public class OurClientNewServiceImpl implements OurClientNewService {

    @Autowired
    private OurClientNewDao ourClientNewDao;

    @Override
    @Transactional
    public void insert(OurClientsNewEntity ourClientsNewEntity) {
        ourClientNewDao.insert(ourClientsNewEntity);

    }

    @Override
    @Transactional

    public void edit(OurClientsNewEntity ourClientsNewEntity) {
        ourClientNewDao.edit(ourClientsNewEntity);

    }

    @Override
    @Transactional

    public void delete(String companyRegNo) {
        ourClientNewDao.delete(companyRegNo);

    }

    @Override
    @Transactional

    public OurClientsNewEntity getOurClientNew(String companyRegNo) {
        return ourClientNewDao.getOurClientNew(companyRegNo);

    }

    @Override    @Transactional

    public List getAllOurClientNew(String tradingNameAtLocation) {
        return ourClientNewDao.getAllOurClientNew(tradingNameAtLocation);
    }

    @Override
    @Transactional

    public List getAllOurClientNew() {
        return ourClientNewDao.getAllOurClientNew();

    }
}
