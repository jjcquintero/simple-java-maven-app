package com.springapp.mvc.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by bruntha on 12/16/15.
 */
@Entity
@javax.persistence.Table(name = "our_clients_new", schema = "", catalog = "danial")
public class OurClientsNewEntity {
    public OurClientsNewEntity() {
    }

    public OurClientsNewEntity(String comRegNo, String clientRef, String companyName, String placeOfReg, String type, String status, Date dateOfIncoporate, Date accountReferrenceDate, Integer utrNo, Integer taxDistrictNo, String accountOffice, String payeRef, String nestId, Integer vat, String officer1, String officer2, String officer3, String notesDates, String notesAccount, String notesAnnualReturn, String notes, String dateStatus, String accountLastAcMadeUpTo, String accountNextAcDue1, String accountNextAcDue2, String annualLastArMadeUpTo, String annualNextArMadeUpTo, String annualNextArDue, String annualLastFullMemberList, String service, String statuaryAccounts, String bookKeeping, String payRoll, String vatSelect) {
        this.comRegNo = comRegNo;
        this.clientRef = clientRef;
        this.companyName = companyName;
        this.placeOfReg = placeOfReg;
        this.type = type;
        this.status = status;
        this.dateOfIncoporate = dateOfIncoporate;
        this.accountReferrenceDate = accountReferrenceDate;
        this.utrNo = utrNo;
        this.taxDistrictNo = taxDistrictNo;
        this.accountOffice = accountOffice;
        this.payeRef = payeRef;
        this.nestId = nestId;
        this.vat = vat;
        this.officer1 = officer1;
        this.officer2 = officer2;
        this.officer3 = officer3;
        this.notesDates = notesDates;
        this.notesAccount = notesAccount;
        this.notesAnnualReturn = notesAnnualReturn;
        this.notes = notes;
        this.dateStatus = dateStatus;
        this.accountLastAcMadeUpTo = accountLastAcMadeUpTo;
        this.accountNextAcDue1 = accountNextAcDue1;
        this.accountNextAcDue2 = accountNextAcDue2;
        this.annualLastArMadeUpTo = annualLastArMadeUpTo;
        this.annualNextArMadeUpTo = annualNextArMadeUpTo;
        this.annualNextArDue = annualNextArDue;
        this.annualLastFullMemberList = annualLastFullMemberList;
        this.service = service;
        this.statuaryAccounts = statuaryAccounts;
        this.bookKeeping = bookKeeping;
        this.payRoll = payRoll;
        this.vatSelect = vatSelect;
    }

    private String comRegNo;

    @Id
    @javax.persistence.Column(name = "com_reg_no")
    public String getComRegNo() {
        return comRegNo;
    }

    public void setComRegNo(String comRegNo) {
        this.comRegNo = comRegNo;
    }

    private String clientRef;

    @Basic
    @javax.persistence.Column(name = "client_ref")
    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    private String companyName;

    @Basic
    @javax.persistence.Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String placeOfReg;

    @Basic
    @javax.persistence.Column(name = "place_of_reg")
    public String getPlaceOfReg() {
        return placeOfReg;
    }

    public void setPlaceOfReg(String placeOfReg) {
        this.placeOfReg = placeOfReg;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Date dateOfIncoporate;

    @Basic
    @javax.persistence.Column(name = "date_of_incoporate")
    public Date getDateOfIncoporate() {
        return dateOfIncoporate;
    }

    public void setDateOfIncoporate(Date dateOfIncoporate) {
        this.dateOfIncoporate = dateOfIncoporate;
    }

    private Date accountReferrenceDate;

    @Basic
    @javax.persistence.Column(name = "account_referrence_date")
    public Date getAccountReferrenceDate() {
        return accountReferrenceDate;
    }

    public void setAccountReferrenceDate(Date accountReferrenceDate) {
        this.accountReferrenceDate = accountReferrenceDate;
    }

    private Integer utrNo;

    @Basic
    @javax.persistence.Column(name = "utr_no")
    public Integer getUtrNo() {
        return utrNo;
    }

    public void setUtrNo(Integer utrNo) {
        this.utrNo = utrNo;
    }

    private Integer taxDistrictNo;

    @Basic
    @javax.persistence.Column(name = "tax_district_no")
    public Integer getTaxDistrictNo() {
        return taxDistrictNo;
    }

    public void setTaxDistrictNo(Integer taxDistrictNo) {
        this.taxDistrictNo = taxDistrictNo;
    }

    private String accountOffice;

    @Basic
    @javax.persistence.Column(name = "account_office")
    public String getAccountOffice() {
        return accountOffice;
    }

    public void setAccountOffice(String accountOffice) {
        this.accountOffice = accountOffice;
    }

    private String payeRef;

    @Basic
    @javax.persistence.Column(name = "paye_ref")
    public String getPayeRef() {
        return payeRef;
    }

    public void setPayeRef(String payeRef) {
        this.payeRef = payeRef;
    }

    private String nestId;

    @Basic
    @javax.persistence.Column(name = "nest_id")
    public String getNestId() {
        return nestId;
    }

    public void setNestId(String nestId) {
        this.nestId = nestId;
    }

    private Integer vat;

    @Basic
    @javax.persistence.Column(name = "vat")
    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    private String officer1;

    @Basic
    @javax.persistence.Column(name = "officer_1")
    public String getOfficer1() {
        return officer1;
    }

    public void setOfficer1(String officer1) {
        this.officer1 = officer1;
    }

    private String officer2;

    @Basic
    @javax.persistence.Column(name = "officer_2")
    public String getOfficer2() {
        return officer2;
    }

    public void setOfficer2(String officer2) {
        this.officer2 = officer2;
    }

    private String officer3;

    @Basic
    @javax.persistence.Column(name = "officer_3")
    public String getOfficer3() {
        return officer3;
    }

    public void setOfficer3(String officer3) {
        this.officer3 = officer3;
    }

    private String notesDates;

    @Basic
    @javax.persistence.Column(name = "notes_dates")
    public String getNotesDates() {
        return notesDates;
    }

    public void setNotesDates(String notesDates) {
        this.notesDates = notesDates;
    }

    private String notesAccount;

    @Basic
    @javax.persistence.Column(name = "notes_account")
    public String getNotesAccount() {
        return notesAccount;
    }

    public void setNotesAccount(String notesAccount) {
        this.notesAccount = notesAccount;
    }

    private String notesAnnualReturn;

    @Basic
    @javax.persistence.Column(name = "notes_annual_return")
    public String getNotesAnnualReturn() {
        return notesAnnualReturn;
    }

    public void setNotesAnnualReturn(String notesAnnualReturn) {
        this.notesAnnualReturn = notesAnnualReturn;
    }

    private String notes;

    @Basic
    @javax.persistence.Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private String dateStatus;

    @Basic
    @javax.persistence.Column(name = "dateStatus")
    public String getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(String dateStatus) {
        this.dateStatus = dateStatus;
    }

    private String accountLastAcMadeUpTo;

    @Basic
    @javax.persistence.Column(name = "accountLastACMadeUpTo")
    public String getAccountLastAcMadeUpTo() {
        return accountLastAcMadeUpTo;
    }

    public void setAccountLastAcMadeUpTo(String accountLastAcMadeUpTo) {
        this.accountLastAcMadeUpTo = accountLastAcMadeUpTo;
    }

    private String accountNextAcDue1;

    @Basic
    @javax.persistence.Column(name = "accountNextACDue1")
    public String getAccountNextAcDue1() {
        return accountNextAcDue1;
    }

    public void setAccountNextAcDue1(String accountNextAcDue1) {
        this.accountNextAcDue1 = accountNextAcDue1;
    }

    private String accountNextAcDue2;

    @Basic
    @javax.persistence.Column(name = "accountNextACDue2")
    public String getAccountNextAcDue2() {
        return accountNextAcDue2;
    }

    public void setAccountNextAcDue2(String accountNextAcDue2) {
        this.accountNextAcDue2 = accountNextAcDue2;
    }

    private String annualLastArMadeUpTo;

    @Basic
    @javax.persistence.Column(name = "annualLastARMadeUpTo")
    public String getAnnualLastArMadeUpTo() {
        return annualLastArMadeUpTo;
    }

    public void setAnnualLastArMadeUpTo(String annualLastArMadeUpTo) {
        this.annualLastArMadeUpTo = annualLastArMadeUpTo;
    }

    private String annualNextArMadeUpTo;

    @Basic
    @javax.persistence.Column(name = "annualNextARMadeUpTo")
    public String getAnnualNextArMadeUpTo() {
        return annualNextArMadeUpTo;
    }

    public void setAnnualNextArMadeUpTo(String annualNextArMadeUpTo) {
        this.annualNextArMadeUpTo = annualNextArMadeUpTo;
    }

    private String annualNextArDue;

    @Basic
    @javax.persistence.Column(name = "annualNextARDue")
    public String getAnnualNextArDue() {
        return annualNextArDue;
    }

    public void setAnnualNextArDue(String annualNextArDue) {
        this.annualNextArDue = annualNextArDue;
    }

    private String annualLastFullMemberList;

    @Basic
    @javax.persistence.Column(name = "annualLastFullMemberList")
    public String getAnnualLastFullMemberList() {
        return annualLastFullMemberList;
    }

    public void setAnnualLastFullMemberList(String annualLastFullMemberList) {
        this.annualLastFullMemberList = annualLastFullMemberList;
    }

    private String service;

    @Basic
    @javax.persistence.Column(name = "service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    private String statuaryAccounts;

    @Basic
    @javax.persistence.Column(name = "statuaryAccounts")
    public String getStatuaryAccounts() {
        return statuaryAccounts;
    }

    public void setStatuaryAccounts(String statuaryAccounts) {
        this.statuaryAccounts = statuaryAccounts;
    }

    private String bookKeeping;

    @Basic
    @javax.persistence.Column(name = "bookKeeping")
    public String getBookKeeping() {
        return bookKeeping;
    }

    public void setBookKeeping(String bookKeeping) {
        this.bookKeeping = bookKeeping;
    }

    private String payRoll;

    @Basic
    @javax.persistence.Column(name = "payRoll")
    public String getPayRoll() {
        return payRoll;
    }

    public void setPayRoll(String payRoll) {
        this.payRoll = payRoll;
    }

    private String vatSelect;

    @Basic
    @javax.persistence.Column(name = "vatSelect")
    public String getVatSelect() {
        return vatSelect;
    }

    public void setVatSelect(String vatSelect) {
        this.vatSelect = vatSelect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OurClientsNewEntity that = (OurClientsNewEntity) o;

        if (accountLastAcMadeUpTo != null ? !accountLastAcMadeUpTo.equals(that.accountLastAcMadeUpTo) : that.accountLastAcMadeUpTo != null)
            return false;
        if (accountNextAcDue1 != null ? !accountNextAcDue1.equals(that.accountNextAcDue1) : that.accountNextAcDue1 != null)
            return false;
        if (accountNextAcDue2 != null ? !accountNextAcDue2.equals(that.accountNextAcDue2) : that.accountNextAcDue2 != null)
            return false;
        if (accountOffice != null ? !accountOffice.equals(that.accountOffice) : that.accountOffice != null)
            return false;
        if (accountReferrenceDate != null ? !accountReferrenceDate.equals(that.accountReferrenceDate) : that.accountReferrenceDate != null)
            return false;
        if (annualLastArMadeUpTo != null ? !annualLastArMadeUpTo.equals(that.annualLastArMadeUpTo) : that.annualLastArMadeUpTo != null)
            return false;
        if (annualLastFullMemberList != null ? !annualLastFullMemberList.equals(that.annualLastFullMemberList) : that.annualLastFullMemberList != null)
            return false;
        if (annualNextArDue != null ? !annualNextArDue.equals(that.annualNextArDue) : that.annualNextArDue != null)
            return false;
        if (annualNextArMadeUpTo != null ? !annualNextArMadeUpTo.equals(that.annualNextArMadeUpTo) : that.annualNextArMadeUpTo != null)
            return false;
        if (bookKeeping != null ? !bookKeeping.equals(that.bookKeeping) : that.bookKeeping != null) return false;
        if (clientRef != null ? !clientRef.equals(that.clientRef) : that.clientRef != null) return false;
        if (comRegNo != null ? !comRegNo.equals(that.comRegNo) : that.comRegNo != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (dateOfIncoporate != null ? !dateOfIncoporate.equals(that.dateOfIncoporate) : that.dateOfIncoporate != null)
            return false;
        if (dateStatus != null ? !dateStatus.equals(that.dateStatus) : that.dateStatus != null) return false;
        if (nestId != null ? !nestId.equals(that.nestId) : that.nestId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (notesAccount != null ? !notesAccount.equals(that.notesAccount) : that.notesAccount != null) return false;
        if (notesAnnualReturn != null ? !notesAnnualReturn.equals(that.notesAnnualReturn) : that.notesAnnualReturn != null)
            return false;
        if (notesDates != null ? !notesDates.equals(that.notesDates) : that.notesDates != null) return false;
        if (officer1 != null ? !officer1.equals(that.officer1) : that.officer1 != null) return false;
        if (officer2 != null ? !officer2.equals(that.officer2) : that.officer2 != null) return false;
        if (officer3 != null ? !officer3.equals(that.officer3) : that.officer3 != null) return false;
        if (payRoll != null ? !payRoll.equals(that.payRoll) : that.payRoll != null) return false;
        if (payeRef != null ? !payeRef.equals(that.payeRef) : that.payeRef != null) return false;
        if (placeOfReg != null ? !placeOfReg.equals(that.placeOfReg) : that.placeOfReg != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (statuaryAccounts != null ? !statuaryAccounts.equals(that.statuaryAccounts) : that.statuaryAccounts != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (taxDistrictNo != null ? !taxDistrictNo.equals(that.taxDistrictNo) : that.taxDistrictNo != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (utrNo != null ? !utrNo.equals(that.utrNo) : that.utrNo != null) return false;
        if (vat != null ? !vat.equals(that.vat) : that.vat != null) return false;
        if (vatSelect != null ? !vatSelect.equals(that.vatSelect) : that.vatSelect != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comRegNo != null ? comRegNo.hashCode() : 0;
        result = 31 * result + (clientRef != null ? clientRef.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (placeOfReg != null ? placeOfReg.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateOfIncoporate != null ? dateOfIncoporate.hashCode() : 0);
        result = 31 * result + (accountReferrenceDate != null ? accountReferrenceDate.hashCode() : 0);
        result = 31 * result + (utrNo != null ? utrNo.hashCode() : 0);
        result = 31 * result + (taxDistrictNo != null ? taxDistrictNo.hashCode() : 0);
        result = 31 * result + (accountOffice != null ? accountOffice.hashCode() : 0);
        result = 31 * result + (payeRef != null ? payeRef.hashCode() : 0);
        result = 31 * result + (nestId != null ? nestId.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (officer1 != null ? officer1.hashCode() : 0);
        result = 31 * result + (officer2 != null ? officer2.hashCode() : 0);
        result = 31 * result + (officer3 != null ? officer3.hashCode() : 0);
        result = 31 * result + (notesDates != null ? notesDates.hashCode() : 0);
        result = 31 * result + (notesAccount != null ? notesAccount.hashCode() : 0);
        result = 31 * result + (notesAnnualReturn != null ? notesAnnualReturn.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (dateStatus != null ? dateStatus.hashCode() : 0);
        result = 31 * result + (accountLastAcMadeUpTo != null ? accountLastAcMadeUpTo.hashCode() : 0);
        result = 31 * result + (accountNextAcDue1 != null ? accountNextAcDue1.hashCode() : 0);
        result = 31 * result + (accountNextAcDue2 != null ? accountNextAcDue2.hashCode() : 0);
        result = 31 * result + (annualLastArMadeUpTo != null ? annualLastArMadeUpTo.hashCode() : 0);
        result = 31 * result + (annualNextArMadeUpTo != null ? annualNextArMadeUpTo.hashCode() : 0);
        result = 31 * result + (annualNextArDue != null ? annualNextArDue.hashCode() : 0);
        result = 31 * result + (annualLastFullMemberList != null ? annualLastFullMemberList.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (statuaryAccounts != null ? statuaryAccounts.hashCode() : 0);
        result = 31 * result + (bookKeeping != null ? bookKeeping.hashCode() : 0);
        result = 31 * result + (payRoll != null ? payRoll.hashCode() : 0);
        result = 31 * result + (vatSelect != null ? vatSelect.hashCode() : 0);
        return result;
    }
}
