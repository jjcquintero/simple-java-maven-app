package com.springapp.mvc.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bruntha on 12/16/15.
 */
@Entity
@javax.persistence.Table(name = "marketing_main", schema = "", catalog = "danial")
public class MarketingMainEntity {
    public MarketingMainEntity() {
    }

    public MarketingMainEntity(String companyRegNo, String addedToPotentialClient, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String county, String mailId, String dateOfIncorporation, String forename, String initial, String jobFunction, String jobTitle, String nextAccountsDue, String nextReturnDue, String postcode, String status, String surname, String telephoneNumber, String title, String town, String tradingNameAtLocation, String curn) {
        this.companyRegNo = companyRegNo;
        this.addedToPotentialClient = addedToPotentialClient;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.county = county;
        this.mailId = mailId;
        this.dateOfIncorporation = dateOfIncorporation;
        this.forename = forename;
        this.initial = initial;
        this.jobFunction = jobFunction;
        this.jobTitle = jobTitle;
        this.nextAccountsDue = nextAccountsDue;
        this.nextReturnDue = nextReturnDue;
        this.postcode = postcode;
        this.status = status;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.title = title;
        this.town = town;
        this.tradingNameAtLocation = tradingNameAtLocation;
        this.curn = curn;
    }

    private String companyRegNo;

    @Id
    @javax.persistence.Column(name = "company_reg_no")
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    private String addedToPotentialClient;

    @Basic
    @javax.persistence.Column(name = "added_to_potential_client")
    public String getAddedToPotentialClient() {
        return addedToPotentialClient;
    }

    public void setAddedToPotentialClient(String addedToPotentialClient) {
        this.addedToPotentialClient = addedToPotentialClient;
    }

    private String addressLine1;

    @Basic
    @javax.persistence.Column(name = "address_line_1")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    private String addressLine2;

    @Basic
    @javax.persistence.Column(name = "address_line_2")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    private String addressLine3;

    @Basic
    @javax.persistence.Column(name = "address_line_3")
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    private String addressLine4;

    @Basic
    @javax.persistence.Column(name = "address_line_4")
    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    private String county;

    @Basic
    @javax.persistence.Column(name = "county")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    private String mailId;

    @Basic
    @javax.persistence.Column(name = "mailID")
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    private String dateOfIncorporation;

    @Basic
    @javax.persistence.Column(name = "date_of_incorporation")
    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    private String forename;

    @Basic
    @javax.persistence.Column(name = "forename")
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    private String initial;

    @Basic
    @javax.persistence.Column(name = "initial")
    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    private String jobFunction;

    @Basic
    @javax.persistence.Column(name = "job_function")
    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
    }

    private String jobTitle;

    @Basic
    @javax.persistence.Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    private String nextAccountsDue;

    @Basic
    @javax.persistence.Column(name = "next_accounts_due")
    public String getNextAccountsDue() {
        return nextAccountsDue;
    }

    public void setNextAccountsDue(String nextAccountsDue) {
        this.nextAccountsDue = nextAccountsDue;
    }

    private String nextReturnDue;

    @Basic
    @javax.persistence.Column(name = "next_return_due")
    public String getNextReturnDue() {
        return nextReturnDue;
    }

    public void setNextReturnDue(String nextReturnDue) {
        this.nextReturnDue = nextReturnDue;
    }

    private String postcode;

    @Basic
    @javax.persistence.Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String surname;

    @Basic
    @javax.persistence.Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String telephoneNumber;

    @Basic
    @javax.persistence.Column(name = "telephone_number")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    private String title;

    @Basic
    @javax.persistence.Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String town;

    @Basic
    @javax.persistence.Column(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    private String tradingNameAtLocation;

    @Basic
    @javax.persistence.Column(name = "trading_name_at_location")
    public String getTradingNameAtLocation() {
        return tradingNameAtLocation;
    }

    public void setTradingNameAtLocation(String tradingNameAtLocation) {
        this.tradingNameAtLocation = tradingNameAtLocation;
    }

    private String curn;

    @Basic
    @javax.persistence.Column(name = "curn")
    public String getCurn() {
        return curn;
    }

    public void setCurn(String curn) {
        this.curn = curn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketingMainEntity that = (MarketingMainEntity) o;

        if (addedToPotentialClient != null ? !addedToPotentialClient.equals(that.addedToPotentialClient) : that.addedToPotentialClient != null)
            return false;
        if (addressLine1 != null ? !addressLine1.equals(that.addressLine1) : that.addressLine1 != null) return false;
        if (addressLine2 != null ? !addressLine2.equals(that.addressLine2) : that.addressLine2 != null) return false;
        if (addressLine3 != null ? !addressLine3.equals(that.addressLine3) : that.addressLine3 != null) return false;
        if (addressLine4 != null ? !addressLine4.equals(that.addressLine4) : that.addressLine4 != null) return false;
        if (companyRegNo != null ? !companyRegNo.equals(that.companyRegNo) : that.companyRegNo != null) return false;
        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (curn != null ? !curn.equals(that.curn) : that.curn != null) return false;
        if (dateOfIncorporation != null ? !dateOfIncorporation.equals(that.dateOfIncorporation) : that.dateOfIncorporation != null)
            return false;
        if (forename != null ? !forename.equals(that.forename) : that.forename != null) return false;
        if (initial != null ? !initial.equals(that.initial) : that.initial != null) return false;
        if (jobFunction != null ? !jobFunction.equals(that.jobFunction) : that.jobFunction != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (mailId != null ? !mailId.equals(that.mailId) : that.mailId != null) return false;
        if (nextAccountsDue != null ? !nextAccountsDue.equals(that.nextAccountsDue) : that.nextAccountsDue != null)
            return false;
        if (nextReturnDue != null ? !nextReturnDue.equals(that.nextReturnDue) : that.nextReturnDue != null)
            return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (telephoneNumber != null ? !telephoneNumber.equals(that.telephoneNumber) : that.telephoneNumber != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (tradingNameAtLocation != null ? !tradingNameAtLocation.equals(that.tradingNameAtLocation) : that.tradingNameAtLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyRegNo != null ? companyRegNo.hashCode() : 0;
        result = 31 * result + (addedToPotentialClient != null ? addedToPotentialClient.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (addressLine3 != null ? addressLine3.hashCode() : 0);
        result = 31 * result + (addressLine4 != null ? addressLine4.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (mailId != null ? mailId.hashCode() : 0);
        result = 31 * result + (dateOfIncorporation != null ? dateOfIncorporation.hashCode() : 0);
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        result = 31 * result + (initial != null ? initial.hashCode() : 0);
        result = 31 * result + (jobFunction != null ? jobFunction.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (nextAccountsDue != null ? nextAccountsDue.hashCode() : 0);
        result = 31 * result + (nextReturnDue != null ? nextReturnDue.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (telephoneNumber != null ? telephoneNumber.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (tradingNameAtLocation != null ? tradingNameAtLocation.hashCode() : 0);
        result = 31 * result + (curn != null ? curn.hashCode() : 0);
        return result;
    }
}
