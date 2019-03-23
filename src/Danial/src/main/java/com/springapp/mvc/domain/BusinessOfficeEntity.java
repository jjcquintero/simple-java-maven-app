package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by bruntha on 12/16/15.
 */
@Entity
@Table(name = "business_office", schema = "", catalog = "danial")
public class BusinessOfficeEntity {
    private String companyRegNo;
    private String careOfB;
    private String addressLine1B;
    private String addressLine2B;
    private String addressLine3B;
    private String addressLine4B;
    private String localityB;
    private String regionB;
    private String postalCodeB;

    public BusinessOfficeEntity() {
        this.companyRegNo = "";
        this.careOfB = "";
        this.addressLine1B = "";
        this.addressLine2B = "";
        this.addressLine3B = "";
        this.addressLine4B = "";
        this.localityB = "";
        this.regionB = "";
        this.postalCodeB = "";
    }

    public BusinessOfficeEntity(String companyRegNo, String careOfB, String addressLine1B, String addressLine2B, String addressLine3B, String addressLine4B, String localityB, String regionB, String postalCodeB) {
        this.companyRegNo = companyRegNo;
        this.careOfB = careOfB;
        this.addressLine1B = addressLine1B;
        this.addressLine2B = addressLine2B;
        this.addressLine3B = addressLine3B;
        this.addressLine4B = addressLine4B;
        this.localityB = localityB;
        this.regionB = regionB;
        this.postalCodeB = postalCodeB;
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
    @Column(name = "care_ofB")
    public String getCareOfB() {
        return careOfB;
    }

    public void setCareOfB(String careOfB) {
        this.careOfB = careOfB;
    }

    @Basic
    @Column(name = "addressLine1B")
    public String getAddressLine1B() {
        return addressLine1B;
    }

    public void setAddressLine1B(String addressLine1B) {
        this.addressLine1B = addressLine1B;
    }

    @Basic
    @Column(name = "addressLine2B")
    public String getAddressLine2B() {
        return addressLine2B;
    }

    public void setAddressLine2B(String addressLine2B) {
        this.addressLine2B = addressLine2B;
    }

    @Basic
    @Column(name = "addressLine3B")
    public String getAddressLine3B() {
        return addressLine3B;
    }

    public void setAddressLine3B(String addressLine3B) {
        this.addressLine3B = addressLine3B;
    }

    @Basic
    @Column(name = "addressLine4B")
    public String getAddressLine4B() {
        return addressLine4B;
    }

    public void setAddressLine4B(String addressLine4B) {
        this.addressLine4B = addressLine4B;
    }

    @Basic
    @Column(name = "localityB")
    public String getLocalityB() {
        return localityB;
    }

    public void setLocalityB(String localityB) {
        this.localityB = localityB;
    }

    @Basic
    @Column(name = "regionB")
    public String getRegionB() {
        return regionB;
    }

    public void setRegionB(String regionB) {
        this.regionB = regionB;
    }

    @Basic
    @Column(name = "postal_codeB")
    public String getPostalCodeB() {
        return postalCodeB;
    }

    public void setPostalCodeB(String postalCodeB) {
        this.postalCodeB = postalCodeB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessOfficeEntity that = (BusinessOfficeEntity) o;

        if (addressLine1B != null ? !addressLine1B.equals(that.addressLine1B) : that.addressLine1B != null)
            return false;
        if (addressLine2B != null ? !addressLine2B.equals(that.addressLine2B) : that.addressLine2B != null)
            return false;
        if (addressLine3B != null ? !addressLine3B.equals(that.addressLine3B) : that.addressLine3B != null)
            return false;
        if (addressLine4B != null ? !addressLine4B.equals(that.addressLine4B) : that.addressLine4B != null)
            return false;
        if (careOfB != null ? !careOfB.equals(that.careOfB) : that.careOfB != null) return false;
        if (companyRegNo != null ? !companyRegNo.equals(that.companyRegNo) : that.companyRegNo != null) return false;
        if (localityB != null ? !localityB.equals(that.localityB) : that.localityB != null) return false;
        if (postalCodeB != null ? !postalCodeB.equals(that.postalCodeB) : that.postalCodeB != null) return false;
        if (regionB != null ? !regionB.equals(that.regionB) : that.regionB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyRegNo != null ? companyRegNo.hashCode() : 0;
        result = 31 * result + (careOfB != null ? careOfB.hashCode() : 0);
        result = 31 * result + (addressLine1B != null ? addressLine1B.hashCode() : 0);
        result = 31 * result + (addressLine2B != null ? addressLine2B.hashCode() : 0);
        result = 31 * result + (addressLine3B != null ? addressLine3B.hashCode() : 0);
        result = 31 * result + (addressLine4B != null ? addressLine4B.hashCode() : 0);
        result = 31 * result + (localityB != null ? localityB.hashCode() : 0);
        result = 31 * result + (regionB != null ? regionB.hashCode() : 0);
        result = 31 * result + (postalCodeB != null ? postalCodeB.hashCode() : 0);
        return result;
    }
}
