package com.springapp.mvc.domain;

/**
 * Created by bruntha on 12/14/15.
 */
public class DatesAndNote {
    String dateDay;
    String dateMonth;
    String dateDateOfIncorporation;
    String dateACRefDate;
    String accountLastACMadeUpTo;
    String accountNextAccountDue1;
    String accountNextAccountDue2;
    String annualLastARMadeUpTo;
    String annualNextARMadeUpTo;
    String annualNextARDue;
    String annualLastFullMembersList;

    public DatesAndNote() {
    }

    public DatesAndNote(String dateDay, String dateMonth, String dateDateOfIncorporation, String dateACRefDate, String accountLastACMadeUpTo, String accountNextAccountDue1, String accountNextAccountDue2, String annualLastARMadeUpTo, String annualNextARMadeUpTo, String annualNextARDue, String annualLastFullMembersList) {
        this.dateDay = dateDay;
        this.dateMonth = dateMonth;
        this.dateDateOfIncorporation = dateDateOfIncorporation;
        this.dateACRefDate = dateACRefDate;
        this.accountLastACMadeUpTo = accountLastACMadeUpTo;
        this.accountNextAccountDue1 = accountNextAccountDue1;
        this.accountNextAccountDue2 = accountNextAccountDue2;
        this.annualLastARMadeUpTo = annualLastARMadeUpTo;
        this.annualNextARMadeUpTo = annualNextARMadeUpTo;
        this.annualNextARDue = annualNextARDue;
        this.annualLastFullMembersList = annualLastFullMembersList;
    }

    public String getDateDay() {
        return dateDay;
    }

    public void setDateDay(String dateDay) {
        this.dateDay = dateDay;
    }

    public String getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(String dateMonth) {
        this.dateMonth = dateMonth;
    }

    public String getDateDateOfIncorporation() {
        return dateDateOfIncorporation;
    }

    public void setDateDateOfIncorporation(String dateDateOfIncorporation) {
        this.dateDateOfIncorporation = dateDateOfIncorporation;
    }

    public String getDateACRefDate() {
        return dateACRefDate;
    }

    public void setDateACRefDate(String dateACRefDate) {
        this.dateACRefDate = dateACRefDate;
    }

    public String getAccountLastACMadeUpTo() {
        return accountLastACMadeUpTo;
    }

    public void setAccountLastACMadeUpTo(String accountLastACMadeUpTo) {
        this.accountLastACMadeUpTo = accountLastACMadeUpTo;
    }

    public String getAccountNextAccountDue1() {
        return accountNextAccountDue1;
    }

    public void setAccountNextAccountDue1(String accountNextAccountDue1) {
        this.accountNextAccountDue1 = accountNextAccountDue1;
    }

    public String getAccountNextAccountDue2() {
        return accountNextAccountDue2;
    }

    public void setAccountNextAccountDue2(String accountNextAccountDue2) {
        this.accountNextAccountDue2 = accountNextAccountDue2;
    }

    public String getAnnualLastARMadeUpTo() {
        return annualLastARMadeUpTo;
    }

    public void setAnnualLastARMadeUpTo(String annualLastARMadeUpTo) {
        this.annualLastARMadeUpTo = annualLastARMadeUpTo;
    }

    public String getAnnualNextARMadeUpTo() {
        return annualNextARMadeUpTo;
    }

    public void setAnnualNextARMadeUpTo(String annualNextARMadeUpTo) {
        this.annualNextARMadeUpTo = annualNextARMadeUpTo;
    }

    public String getAnnualNextARDue() {
        return annualNextARDue;
    }

    public void setAnnualNextARDue(String annualNextARDue) {
        this.annualNextARDue = annualNextARDue;
    }

    public String getAnnualLastFullMembersList() {
        return annualLastFullMembersList;
    }

    public void setAnnualLastFullMembersList(String annualLastFullMembersList) {
        this.annualLastFullMembersList = annualLastFullMembersList;
    }
}
