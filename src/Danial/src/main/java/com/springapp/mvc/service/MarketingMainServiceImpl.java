package com.springapp.mvc.service;

import com.springapp.mvc.dao.MarketingMainDao;
import com.springapp.mvc.domain.MarketingMainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 8/17/15.
 */
@Service
public class MarketingMainServiceImpl implements MarketingMainService {

    @Autowired
    private MarketingMainDao marketingMainDao;

    @Override
    @Transactional
    public void insert(MarketingMainEntity marketingMainEntity) {
        marketingMainDao.insert(marketingMainEntity);
    }

    @Override
    @Transactional
    public void edit(MarketingMainEntity marketingMainEntity) {
        marketingMainDao.edit(marketingMainEntity);

    }

    @Override
    @Transactional
    public void delete(String companyRegNo) {
        marketingMainDao.delete(companyRegNo);

    }

    @Override
    @Transactional
    public MarketingMainEntity getMarketingMain(String companyRegNo) {
        return marketingMainDao.getMarketingMain(companyRegNo);

    }

    @Override
    @Transactional
    public List getAllMarketingMain() {
        return marketingMainDao.getAllMarketingMain();

    }
}
