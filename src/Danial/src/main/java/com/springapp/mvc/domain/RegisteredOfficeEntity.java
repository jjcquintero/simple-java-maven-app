package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by bruntha on 12/16/15.
 */
@Entity
@Table(name = "registered_office", schema = "", catalog = "danial")
public class RegisteredOfficeEntity {
    private String companyRegNo;
    private String careOfR;
    private String addressLine1R;
    private String addressLine2R;
    private String addressLine3R;
    private String addressLine4R;
    private String localityR;
    private String regionR;
    private String postalCodeR;

    public RegisteredOfficeEntity() {
        this.companyRegNo = "";
        this.careOfR = "";
        this.addressLine1R = "";
        this.addressLine2R = "";
        this.addressLine3R = "";
        this.addressLine4R = "";
        this.localityR = "";
        this.regionR = "";
        this.postalCodeR = "";
    }

    public RegisteredOfficeEntity(String companyRegNo, String careOfR, String addressLine1R, String addressLine2R, String addressLine3R, String addressLine4R, String localityR, String regionR, String postalCodeR) {
        this.companyRegNo = companyRegNo;
        this.careOfR = careOfR;
        this.addressLine1R = addressLine1R;
        this.addressLine2R = addressLine2R;
        this.addressLine3R = addressLine3R;
        this.addressLine4R = addressLine4R;
        this.localityR = localityR;
        this.regionR = regionR;
        this.postalCodeR = postalCodeR;
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
    @Column(name = "care_ofR")
    public String getCareOfR() {
        return careOfR;
    }

    public void setCareOfR(String careOfR) {
        this.careOfR = careOfR;
    }

    @Basic
    @Column(name = "addressLine1R")
    public String getAddressLine1R() {
        return addressLine1R;
    }

    public void setAddressLine1R(String addressLine1R) {
        this.addressLine1R = addressLine1R;
    }

    @Basic
    @Column(name = "addressLine2R")
    public String getAddressLine2R() {
        return addressLine2R;
    }

    public void setAddressLine2R(String addressLine2R) {
        this.addressLine2R = addressLine2R;
    }

    @Basic
    @Column(name = "addressLine3R")
    public String getAddressLine3R() {
        return addressLine3R;
    }

    public void setAddressLine3R(String addressLine3R) {
        this.addressLine3R = addressLine3R;
    }

    @Basic
    @Column(name = "addressLine4R")
    public String getAddressLine4R() {
        return addressLine4R;
    }

    public void setAddressLine4R(String addressLine4R) {
        this.addressLine4R = addressLine4R;
    }

    @Basic
    @Column(name = "localityR")
    public String getLocalityR() {
        return localityR;
    }

    public void setLocalityR(String localityR) {
        this.localityR = localityR;
    }

    @Basic
    @Column(name = "regionR")
    public String getRegionR() {
        return regionR;
    }

    public void setRegionR(String regionR) {
        this.regionR = regionR;
    }

    @Basic
    @Column(name = "postal_codeR")
    public String getPostalCodeR() {
        return postalCodeR;
    }

    public void setPostalCodeR(String postalCodeR) {
        this.postalCodeR = postalCodeR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisteredOfficeEntity that = (RegisteredOfficeEntity) o;

        if (addressLine1R != null ? !addressLine1R.equals(that.addressLine1R) : that.addressLine1R != null)
            return false;
        if (addressLine2R != null ? !addressLine2R.equals(that.addressLine2R) : that.addressLine2R != null)
            return false;
        if (addressLine3R != null ? !addressLine3R.equals(that.addressLine3R) : that.addressLine3R != null)
            return false;
        if (addressLine4R != null ? !addressLine4R.equals(that.addressLine4R) : that.addressLine4R != null)
            return false;
        if (careOfR != null ? !careOfR.equals(that.careOfR) : that.careOfR != null) return false;
        if (companyRegNo != null ? !companyRegNo.equals(that.companyRegNo) : that.companyRegNo != null) return false;
        if (localityR != null ? !localityR.equals(that.localityR) : that.localityR != null) return false;
        if (postalCodeR != null ? !postalCodeR.equals(that.postalCodeR) : that.postalCodeR != null) return false;
        if (regionR != null ? !regionR.equals(that.regionR) : that.regionR != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyRegNo != null ? companyRegNo.hashCode() : 0;
        result = 31 * result + (careOfR != null ? careOfR.hashCode() : 0);
        result = 31 * result + (addressLine1R != null ? addressLine1R.hashCode() : 0);
        result = 31 * result + (addressLine2R != null ? addressLine2R.hashCode() : 0);
        result = 31 * result + (addressLine3R != null ? addressLine3R.hashCode() : 0);
        result = 31 * result + (addressLine4R != null ? addressLine4R.hashCode() : 0);
        result = 31 * result + (localityR != null ? localityR.hashCode() : 0);
        result = 31 * result + (regionR != null ? regionR.hashCode() : 0);
        result = 31 * result + (postalCodeR != null ? postalCodeR.hashCode() : 0);
        return result;
    }
}
