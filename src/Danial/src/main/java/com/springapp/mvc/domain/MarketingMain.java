package com.springapp.mvc.domain;

/**
 * Created by bruntha on 8/11/15.
 */
public class MarketingMain {
    private String companyRegNo="";
    private String addressLine1="";
    private String addressLine2="";
    private String addressLine3="";
    private String addressLine4="";
    private String addedToPotentialClient="";
    private String country="";
    private String mailID ="";
    private String dateOfIncorporation="";
    private String foreName="";
    private String initial="";
    private String jobFuntion="";
    private String jobTitile="";
    private String nextAccountDue="";
    private String nextReturnDue="";
    private String postCode="";
    private String status="";
    private String surname="";
    private String telephoneNumber="";
    private String title="";
    private String town="";
    private String tradingNameAtLocation="";

    private RegisteredOfficeEntity registeredOfficeEntity;

    public MarketingMain() {
    }

    public MarketingMain(String companyRegNo, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addedToPotentialClient, String country, String mailID, String dateOfIncorporation, String foreName, String initial, String jobFuntion, String jobTitile, String nextAccountDue, String nextReturnDue, String postCode, String status, String surname, String telephoneNumber, String title, String town, String tradingNameAtLocation, RegisteredOfficeEntity registeredOfficeEntity) {
        this.companyRegNo = companyRegNo;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.addedToPotentialClient = addedToPotentialClient;
        this.country = country;
        this.mailID = mailID;
        this.dateOfIncorporation = dateOfIncorporation;
        this.foreName = foreName;
        this.initial = initial;
        this.jobFuntion = jobFuntion;
        this.jobTitile = jobTitile;
        this.nextAccountDue = nextAccountDue;
        this.nextReturnDue = nextReturnDue;
        this.postCode = postCode;
        this.status = status;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.title = title;
        this.town = town;
        this.tradingNameAtLocation = tradingNameAtLocation;
        this.registeredOfficeEntity = registeredOfficeEntity;
    }

    public RegisteredOfficeEntity getRegisteredOfficeEntity() {
        return registeredOfficeEntity;
    }

    public void setRegisteredOfficeEntity(RegisteredOfficeEntity registeredOfficeEntity) {
        this.registeredOfficeEntity = registeredOfficeEntity;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getAddedToPotentialClient() {
        return addedToPotentialClient;
    }

    public void setAddedToPotentialClient(String addedToPotentialClient) {
        this.addedToPotentialClient = addedToPotentialClient;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getJobFuntion() {
        return jobFuntion;
    }

    public void setJobFuntion(String jobFuntion) {
        this.jobFuntion = jobFuntion;
    }

    public String getJobTitile() {
        return jobTitile;
    }

    public void setJobTitile(String jobTitile) {
        this.jobTitile = jobTitile;
    }

    public String getNextAccountDue() {
        return nextAccountDue;
    }

    public void setNextAccountDue(String nextAccountDue) {
        this.nextAccountDue = nextAccountDue;
    }

    public String getNextReturnDue() {
        return nextReturnDue;
    }

    public void setNextReturnDue(String nextReturnDue) {
        this.nextReturnDue = nextReturnDue;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTradingNameAtLocation() {
        return tradingNameAtLocation;
    }

    public void setTradingNameAtLocation(String tradingNameAtLocation) {
        this.tradingNameAtLocation = tradingNameAtLocation;
    }
}
