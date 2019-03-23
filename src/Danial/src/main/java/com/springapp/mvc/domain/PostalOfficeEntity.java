package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by bruntha on 12/16/15.
 */
@Entity
@Table(name = "postal_office", schema = "", catalog = "danial")
public class PostalOfficeEntity {
    private String companyRegNo;
    private String careOfP;
    private String addressLine1P;
    private String addressLine2P;
    private String addressLine3P;
    private String addressLine4P;
    private String localityP;
    private String regionP;
    private String postalCodeP;

    public PostalOfficeEntity() {
        this.companyRegNo = "";
        this.careOfP = "";
        this.addressLine1P = "";
        this.addressLine2P = "";
        this.addressLine3P = "";
        this.addressLine4P = "";
        this.localityP = "";
        this.regionP = "";
        this.postalCodeP = "";
    }

    public PostalOfficeEntity(String companyRegNo, String careOfP, String addressLine1P, String addressLine2P, String addressLine3P, String addressLine4P, String localityP, String regionP, String postalCodeP) {
        this.companyRegNo = companyRegNo;
        this.careOfP = careOfP;
        this.addressLine1P = addressLine1P;
        this.addressLine2P = addressLine2P;
        this.addressLine3P = addressLine3P;
        this.addressLine4P = addressLine4P;
        this.localityP = localityP;
        this.regionP = regionP;
        this.postalCodeP = postalCodeP;
    }

    @Id
    @Column(name = "company_reg_no")
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    @Basic
    @Column(name = "care_ofP")
    public String getCareOfP() {
        return careOfP;
    }

    public void setCareOfP(String careOfP) {
        this.careOfP = careOfP;
    }

    @Basic
    @Column(name = "addressLine1P")
    public String getAddressLine1P() {
        return addressLine1P;
    }

    public void setAddressLine1P(String addressLine1P) {
        this.addressLine1P = addressLine1P;
    }

    @Basic
    @Column(name = "addressLine2P")
    public String getAddressLine2P() {
        return addressLine2P;
    }

    public void setAddressLine2P(String addressLine2P) {
        this.addressLine2P = addressLine2P;
    }

    @Basic
    @Column(name = "addressLine3P")
    public String getAddressLine3P() {
        return addressLine3P;
    }

    public void setAddressLine3P(String addressLine3P) {
        this.addressLine3P = addressLine3P;
    }

    @Basic
    @Column(name = "addressLine4P")
    public String getAddressLine4P() {
        return addressLine4P;
    }

    public void setAddressLine4P(String addressLine4P) {
        this.addressLine4P = addressLine4P;
    }

    @Basic
    @Column(name = "localityP")
    public String getLocalityP() {
        return localityP;
    }

    public void setLocalityP(String localityP) {
        this.localityP = localityP;
    }

    @Basic
    @Column(name = "regionP")
    public String getRegionP() {
        return regionP;
    }

    public void setRegionP(String regionP) {
        this.regionP = regionP;
    }

    @Basic
    @Column(name = "postal_codeP")
    public String getPostalCodeP() {
        return postalCodeP;
    }

    public void setPostalCodeP(String postalCodeP) {
        this.postalCodeP = postalCodeP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostalOfficeEntity that = (PostalOfficeEntity) o;

        if (addressLine1P != null ? !addressLine1P.equals(that.addressLine1P) : that.addressLine1P != null)
            return false;
        if (addressLine2P != null ? !addressLine2P.equals(that.addressLine2P) : that.addressLine2P != null)
            return false;
        if (addressLine3P != null ? !addressLine3P.equals(that.addressLine3P) : that.addressLine3P != null)
            return false;
        if (addressLine4P != null ? !addressLine4P.equals(that.addressLine4P) : that.addressLine4P != null)
            return false;
        if (careOfP != null ? !careOfP.equals(that.careOfP) : that.careOfP != null) return false;
        if (companyRegNo != null ? !companyRegNo.equals(that.companyRegNo) : that.companyRegNo != null) return false;
        if (localityP != null ? !localityP.equals(that.localityP) : that.localityP != null) return false;
        if (postalCodeP != null ? !postalCodeP.equals(that.postalCodeP) : that.postalCodeP != null) return false;
        if (regionP != null ? !regionP.equals(that.regionP) : that.regionP != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyRegNo != null ? companyRegNo.hashCode() : 0;
        result = 31 * result + (careOfP != null ? careOfP.hashCode() : 0);
        result = 31 * result + (addressLine1P != null ? addressLine1P.hashCode() : 0);
        result = 31 * result + (addressLine2P != null ? addressLine2P.hashCode() : 0);
        result = 31 * result + (addressLine3P != null ? addressLine3P.hashCode() : 0);
        result = 31 * result + (addressLine4P != null ? addressLine4P.hashCode() : 0);
        result = 31 * result + (localityP != null ? localityP.hashCode() : 0);
        result = 31 * result + (regionP != null ? regionP.hashCode() : 0);
        result = 31 * result + (postalCodeP != null ? postalCodeP.hashCode() : 0);
        return result;
    }
}
