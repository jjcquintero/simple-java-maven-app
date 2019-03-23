package com.springapp.mvc.domain;

/**
 * Created by bruntha on 8/31/15.
 */
public class OurClientsFull extends MarketingMainEntity {
    private String type;

    public String getCompanyName()
    {
        return super.getTradingNameAtLocation();
    }

    public void setCompanyName(String companyName) {
        super.setTradingNameAtLocation(companyName);
    }


    public String getDateOfIncoporate() {
        return super.getDateOfIncorporation();
    }

    public void setDateOfIncorporate(String dateOfIncorporate) {
        super.setDateOfIncorporation(dateOfIncorporate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
