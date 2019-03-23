package com.springapp.mvc.domain;

/**
 * Created by bruntha on 12/13/15.
 */
public class ClientReminderResponse {
    String companyRegNo;
    String clientRef;
    String details;
    String dueDate;
    String responsilbeTo;
    String status;
    String remarks;

    public ClientReminderResponse(String companyRegNo, String clientRef, String details, String dueDate, String responsilbeTo, String status, String remarks) {
        this.companyRegNo = companyRegNo;
        this.clientRef = clientRef;
        this.details = details;
        this.dueDate = dueDate;
        this.responsilbeTo = responsilbeTo;
        this.status = status;
        this.remarks = remarks;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsilbeTo() {
        return responsilbeTo;
    }

    public void setResponsilbeTo(String responsilbeTo) {
        this.responsilbeTo = responsilbeTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
