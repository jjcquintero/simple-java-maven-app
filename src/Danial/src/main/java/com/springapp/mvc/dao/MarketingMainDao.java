package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MarketingMainEntity;

import java.util.List;

/**
 * Created by bruntha on 8/17/15.
 */
public interface MarketingMainDao {

    void insert(MarketingMainEntity marketingMainEntity);
    void edit(MarketingMainEntity marketingMainEntity);
    void delete(String companyRegNo);
    MarketingMainEntity getMarketingMain(String companyRegNo);
    List getAllMarketingMain();
}
