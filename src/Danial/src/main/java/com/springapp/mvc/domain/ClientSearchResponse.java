package com.springapp.mvc.domain;

import java.sql.Date;

/**
 * Created by bruntha on 12/13/15.
 */
public class ClientSearchResponse {
//    OurClientsNewEntity ourClientsNewEntity = new OurClientsNewEntity();
//    RegisteredOfficeEntity registeredOfficeEntity = new RegisteredOfficeEntity();
//    BusinessOfficeEntity businessOfficeEntity = new BusinessOfficeEntity();
//    PostalOfficeEntity postalOfficeEntity = new PostalOfficeEntity();
//    DatesAndNote datesAndNote = new DatesAndNote();
//    ContactDetailsPrivateEntity contactDetailsPrivateEntity = new ContactDetailsPrivateEntity();

    private String companyRegNo;
    private String careOfR;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String locality;
    private String region;
    private String postalCode;

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getCareOfR() {
        return careOfR;
    }

    public void setCareOfR(String careOfR) {
        this.careOfR = careOfR;
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String clientRef;

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String placeOfReg;

    public String getPlaceOfReg() {
        return placeOfReg;
    }

    public void setPlaceOfReg(String placeOfReg) {
        this.placeOfReg = placeOfReg;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Date dateOfIncoporate;

    public Date getDateOfIncoporate() {
        return dateOfIncoporate;
    }

    public void setDateOfIncoporate(Date dateOfIncoporate) {
        this.dateOfIncoporate = dateOfIncoporate;
    }

    private Date accountReferrenceDate;

    public Date getAccountReferrenceDate() {
        return accountReferrenceDate;
    }

    public void setAccountReferrenceDate(Date accountReferrenceDate) {
        this.accountReferrenceDate = accountReferrenceDate;
    }

    private Integer utrNo;

    public Integer getUtrNo() {
        return utrNo;
    }

    public void setUtrNo(Integer utrNo) {
        this.utrNo = utrNo;
    }

    private Integer taxDistrictNo;

    public Integer getTaxDistrictNo() {
        return taxDistrictNo;
    }

    public void setTaxDistrictNo(Integer taxDistrictNo) {
        this.taxDistrictNo = taxDistrictNo;
    }

    private String accountOffice;

    public String getAccountOffice() {
        return accountOffice;
    }

    public void setAccountOffice(String accountOffice) {
        this.accountOffice = accountOffice;
    }

    private String payeRef;

    public String getPayeRef() {
        return payeRef;
    }

    public void setPayeRef(String payeRef) {
        this.payeRef = payeRef;
    }

    private String nestId;

    public String getNestId() {
        return nestId;
    }

    public void setNestId(String nestId) {
        this.nestId = nestId;
    }

    private Integer vat;

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    private String notesDates;

    public String getNotesDates() {
        return notesDates;
    }

    public void setNotesDates(String notesDates) {
        this.notesDates = notesDates;
    }

    private String notesAccount;

    public String getNotesAccount() {
        return notesAccount;
    }

    public void setNotesAccount(String notesAccount) {
        this.notesAccount = notesAccount;
    }

    private String notesAnnualReturn;

    public String getNotesAnnualReturn() {
        return notesAnnualReturn;
    }

    public void setNotesAnnualReturn(String notesAnnualReturn) {
        this.notesAnnualReturn = notesAnnualReturn;
    }

    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

//    public OurClientsNewEntity getOurClientsNewEntity() {
//        return ourClientsNewEntity;
//    }
//
//    public void setOurClientsNewEntity(OurClientsNewEntity ourClientsNewEntity) {
//        this.ourClientsNewEntity = ourClientsNewEntity;
//    }
//
//    public RegisteredOfficeEntity getRegisteredOfficeEntity() {
//        return registeredOfficeEntity;
//    }
//
//    public void setRegisteredOfficeEntity(RegisteredOfficeEntity registeredOfficeEntity) {
//        this.registeredOfficeEntity = registeredOfficeEntity;
//    }
//
//    public BusinessOfficeEntity getBusinessOfficeEntity() {
//        return businessOfficeEntity;
//    }
//
//    public void setBusinessOfficeEntity(BusinessOfficeEntity businessOfficeEntity) {
//        this.businessOfficeEntity = businessOfficeEntity;
//    }
//
//    public PostalOfficeEntity getPostalOfficeEntity() {
//        return postalOfficeEntity;
//    }
//
//    public void setPostalOfficeEntity(PostalOfficeEntity postalOfficeEntity) {
//        this.postalOfficeEntity = postalOfficeEntity;
//    }
//
//    public DatesAndNote getDatesAndNote() {
//        return datesAndNote;
//    }
//
//    public void setDatesAndNote(DatesAndNote datesAndNote) {
//        this.datesAndNote = datesAndNote;
//    }
//
//    public ContactDetailsPrivateEntity getContactDetailsPrivateEntity() {
//        return contactDetailsPrivateEntity;
//    }
//
//    public void setContactDetailsPrivateEntity(ContactDetailsPrivateEntity contactDetailsPrivateEntity) {
//        this.contactDetailsPrivateEntity = contactDetailsPrivateEntity;
//    }
}
