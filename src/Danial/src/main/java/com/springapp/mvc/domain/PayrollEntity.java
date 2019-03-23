package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by bruntha on 12/14/15.
 */
@Entity
@Table(name = "payroll", schema = "", catalog = "danial")
public class PayrollEntity {
    private String comRef;
    private String nameOfTheClient;
    private String paymentMethod;
    private String email;
    private String upToPeriod;
    private String psPrEx;
    private String letter;
    private String checked;
    private String psPri;
    private String letPr;
    private String eMail;
    private String post;
    private String rtiJan;
    private String rtiFeb;
    private String rtiMar;
    private String rtiApr;
    private String rtiMay;
    private String rtiJun;
    private String rtiJul;
    private String rtiAug;
    private String rtiSep;
    private String rtiOct;
    private String rtiNov;
    private String rtiDec;
    private String comments;

    @Id
    @Column(name = "com_ref")
    public String getComRef() {
        return comRef;
    }

    public void setComRef(String comRef) {
        this.comRef = comRef;
    }

    @Basic
    @Column(name = "name_of_the_client")
    public String getNameOfTheClient() {
        return nameOfTheClient;
    }

    public void setNameOfTheClient(String nameOfTheClient) {
        this.nameOfTheClient = nameOfTheClient;
    }

    @Basic
    @Column(name = "payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "up_to_period")
    public String getUpToPeriod() {
        return upToPeriod;
    }

    public void setUpToPeriod(String upToPeriod) {
        this.upToPeriod = upToPeriod;
    }

    @Basic
    @Column(name = "ps_pr_ex")
    public String getPsPrEx() {
        return psPrEx;
    }

    public void setPsPrEx(String psPrEx) {
        this.psPrEx = psPrEx;
    }

    @Basic
    @Column(name = "letter")
    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Basic
    @Column(name = "checked")
    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Basic
    @Column(name = "ps_pri")
    public String getPsPri() {
        return psPri;
    }

    public void setPsPri(String psPri) {
        this.psPri = psPri;
    }

    @Basic
    @Column(name = "let_pr")
    public String getLetPr() {
        return letPr;
    }

    public void setLetPr(String letPr) {
        this.letPr = letPr;
    }

    @Basic
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "rti_jan")
    public String getRtiJan() {
        return rtiJan;
    }

    public void setRtiJan(String rtiJan) {
        this.rtiJan = rtiJan;
    }

    @Basic
    @Column(name = "rti_feb")
    public String getRtiFeb() {
        return rtiFeb;
    }

    public void setRtiFeb(String rtiFeb) {
        this.rtiFeb = rtiFeb;
    }

    @Basic
    @Column(name = "rti_mar")
    public String getRtiMar() {
        return rtiMar;
    }

    public void setRtiMar(String rtiMar) {
        this.rtiMar = rtiMar;
    }

    @Basic
    @Column(name = "rti_apr")
    public String getRtiApr() {
        return rtiApr;
    }

    public void setRtiApr(String rtiApr) {
        this.rtiApr = rtiApr;
    }

    @Basic
    @Column(name = "rti_may")
    public String getRtiMay() {
        return rtiMay;
    }

    public void setRtiMay(String rtiMay) {
        this.rtiMay = rtiMay;
    }

    @Basic
    @Column(name = "rti_jun")
    public String getRtiJun() {
        return rtiJun;
    }

    public void setRtiJun(String rtiJun) {
        this.rtiJun = rtiJun;
    }

    @Basic
    @Column(name = "rti_jul")
    public String getRtiJul() {
        return rtiJul;
    }

    public void setRtiJul(String rtiJul) {
        this.rtiJul = rtiJul;
    }

    @Basic
    @Column(name = "rti_aug")
    public String getRtiAug() {
        return rtiAug;
    }

    public void setRtiAug(String rtiAug) {
        this.rtiAug = rtiAug;
    }

    @Basic
    @Column(name = "rti_sep")
    public String getRtiSep() {
        return rtiSep;
    }

    public void setRtiSep(String rtiSep) {
        this.rtiSep = rtiSep;
    }

    @Basic
    @Column(name = "rti_oct")
    public String getRtiOct() {
        return rtiOct;
    }

    public void setRtiOct(String rtiOct) {
        this.rtiOct = rtiOct;
    }

    @Basic
    @Column(name = "rti_nov")
    public String getRtiNov() {
        return rtiNov;
    }

    public void setRtiNov(String rtiNov) {
        this.rtiNov = rtiNov;
    }

    @Basic
    @Column(name = "rti_dec")
    public String getRtiDec() {
        return rtiDec;
    }

    public void setRtiDec(String rtiDec) {
        this.rtiDec = rtiDec;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayrollEntity that = (PayrollEntity) o;

        if (checked != null ? !checked.equals(that.checked) : that.checked != null) return false;
        if (comRef != null ? !comRef.equals(that.comRef) : that.comRef != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (letPr != null ? !letPr.equals(that.letPr) : that.letPr != null) return false;
        if (letter != null ? !letter.equals(that.letter) : that.letter != null) return false;
        if (nameOfTheClient != null ? !nameOfTheClient.equals(that.nameOfTheClient) : that.nameOfTheClient != null)
            return false;
        if (paymentMethod != null ? !paymentMethod.equals(that.paymentMethod) : that.paymentMethod != null)
            return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (psPrEx != null ? !psPrEx.equals(that.psPrEx) : that.psPrEx != null) return false;
        if (psPri != null ? !psPri.equals(that.psPri) : that.psPri != null) return false;
        if (rtiApr != null ? !rtiApr.equals(that.rtiApr) : that.rtiApr != null) return false;
        if (rtiAug != null ? !rtiAug.equals(that.rtiAug) : that.rtiAug != null) return false;
        if (rtiDec != null ? !rtiDec.equals(that.rtiDec) : that.rtiDec != null) return false;
        if (rtiFeb != null ? !rtiFeb.equals(that.rtiFeb) : that.rtiFeb != null) return false;
        if (rtiJan != null ? !rtiJan.equals(that.rtiJan) : that.rtiJan != null) return false;
        if (rtiJul != null ? !rtiJul.equals(that.rtiJul) : that.rtiJul != null) return false;
        if (rtiJun != null ? !rtiJun.equals(that.rtiJun) : that.rtiJun != null) return false;
        if (rtiMar != null ? !rtiMar.equals(that.rtiMar) : that.rtiMar != null) return false;
        if (rtiMay != null ? !rtiMay.equals(that.rtiMay) : that.rtiMay != null) return false;
        if (rtiNov != null ? !rtiNov.equals(that.rtiNov) : that.rtiNov != null) return false;
        if (rtiOct != null ? !rtiOct.equals(that.rtiOct) : that.rtiOct != null) return false;
        if (rtiSep != null ? !rtiSep.equals(that.rtiSep) : that.rtiSep != null) return false;
        if (upToPeriod != null ? !upToPeriod.equals(that.upToPeriod) : that.upToPeriod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comRef != null ? comRef.hashCode() : 0;
        result = 31 * result + (nameOfTheClient != null ? nameOfTheClient.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (upToPeriod != null ? upToPeriod.hashCode() : 0);
        result = 31 * result + (psPrEx != null ? psPrEx.hashCode() : 0);
        result = 31 * result + (letter != null ? letter.hashCode() : 0);
        result = 31 * result + (checked != null ? checked.hashCode() : 0);
        result = 31 * result + (psPri != null ? psPri.hashCode() : 0);
        result = 31 * result + (letPr != null ? letPr.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (rtiJan != null ? rtiJan.hashCode() : 0);
        result = 31 * result + (rtiFeb != null ? rtiFeb.hashCode() : 0);
        result = 31 * result + (rtiMar != null ? rtiMar.hashCode() : 0);
        result = 31 * result + (rtiApr != null ? rtiApr.hashCode() : 0);
        result = 31 * result + (rtiMay != null ? rtiMay.hashCode() : 0);
        result = 31 * result + (rtiJun != null ? rtiJun.hashCode() : 0);
        result = 31 * result + (rtiJul != null ? rtiJul.hashCode() : 0);
        result = 31 * result + (rtiAug != null ? rtiAug.hashCode() : 0);
        result = 31 * result + (rtiSep != null ? rtiSep.hashCode() : 0);
        result = 31 * result + (rtiOct != null ? rtiOct.hashCode() : 0);
        result = 31 * result + (rtiNov != null ? rtiNov.hashCode() : 0);
        result = 31 * result + (rtiDec != null ? rtiDec.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    public PayrollEntity(String comRef, String nameOfTheClient, String paymentMethod, String email, String upToPeriod,
                         String psPrEx, String letter, String checked, String psPri, String letPr, String eMail, String post,
                         String rtiJan, String rtiFeb, String rtiMar, String rtiApr, String rtiMay, String rtiJun,
                         String rtiJul, String rtiAug, String rtiSep, String rtiOct, String rtiNov, String rtiDec,
                         String comments) {
        this.comRef = comRef;
        this.nameOfTheClient = nameOfTheClient;
        this.paymentMethod = paymentMethod;
        this.email = email;
        this.upToPeriod = upToPeriod;
        this.psPrEx = psPrEx;
        this.letter = letter;
        this.checked = checked;
        this.psPri = psPri;
        this.letPr = letPr;
        this.eMail = eMail;
        this.post = post;
        this.rtiJan = rtiJan;
        this.rtiFeb = rtiFeb;
        this.rtiMar = rtiMar;
        this.rtiApr = rtiApr;
        this.rtiMay = rtiMay;
        this.rtiJun = rtiJun;
        this.rtiJul = rtiJul;
        this.rtiAug = rtiAug;
        this.rtiSep = rtiSep;
        this.rtiOct = rtiOct;
        this.rtiNov = rtiNov;
        this.rtiDec = rtiDec;
        this.comments = comments;
    }

    public PayrollEntity() {
    }
}
