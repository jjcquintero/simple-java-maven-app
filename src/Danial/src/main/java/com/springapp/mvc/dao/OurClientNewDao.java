package com.springapp.mvc.dao;

import com.springapp.mvc.domain.OurClientsNewEntity;

import java.util.List;

/**
 * Created by bruntha on 11/14/15.
 */
public interface OurClientNewDao {
    void insert(OurClientsNewEntity ourClientsNewEntity);
    void edit(OurClientsNewEntity ourClientsNewEntity);
    void delete(String companyRegNo);
    OurClientsNewEntity getOurClientNew(String companyRegNo);
    List getAllOurClientNew(String tradingNameAtLocation);
    List getAllOurClientNew();
}
