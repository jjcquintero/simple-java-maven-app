package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by prakhash on 05/09/15.
 */
@Entity
@Table(name = "appointment", schema = "", catalog = "danial")
public class AppointmentEntity {
    private int appointmentId;
    private String calendar;
    private String client;
    private Byte isActive;
    private String note;
    private Byte repeats;
    private String title;
    private String todate;
    private String venue;
    private String whendate;
    private String whentime;
    private String totime;
    private String companyRegNo;

    @Id
    @Column(name = "appointment_id")
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "calendar")
    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    @Basic
    @Column(name = "client")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "isActive")
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "repeats")
    public Byte getRepeats() {
        return repeats;
    }

    public void setRepeats(Byte repeats) {
        this.repeats = repeats;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "todate")
    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    @Basic
    @Column(name = "venue")
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Basic
    @Column(name = "whendate")
    public String getWhendate() {
        return whendate;
    }

    public void setWhendate(String whendate) {
        this.whendate = whendate;
    }

    @Basic
    @Column(name = "whentime")
    public String getWhentime() {
        return whentime;
    }

    public void setWhentime(String whentime) {
        this.whentime = whentime;
    }

    @Basic
    @Column(name = "totime")
    public String getTotime() {
        return totime;
    }

    public void setTotime(String totime) {
        this.totime = totime;
    }

    @Basic
    @Column(name = "company_reg_no")
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentEntity that = (AppointmentEntity) o;

        if (appointmentId != that.appointmentId) return false;
        if (calendar != null ? !calendar.equals(that.calendar) : that.calendar != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (companyRegNo != null ? !companyRegNo.equals(that.companyRegNo) : that.companyRegNo != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (repeats != null ? !repeats.equals(that.repeats) : that.repeats != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (todate != null ? !todate.equals(that.todate) : that.todate != null) return false;
        if (totime != null ? !totime.equals(that.totime) : that.totime != null) return false;
        if (venue != null ? !venue.equals(that.venue) : that.venue != null) return false;
        if (whendate != null ? !whendate.equals(that.whendate) : that.whendate != null) return false;
        if (whentime != null ? !whentime.equals(that.whentime) : that.whentime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appointmentId;
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (repeats != null ? repeats.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (todate != null ? todate.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (whendate != null ? whendate.hashCode() : 0);
        result = 31 * result + (whentime != null ? whentime.hashCode() : 0);
        result = 31 * result + (totime != null ? totime.hashCode() : 0);
        result = 31 * result + (companyRegNo != null ? companyRegNo.hashCode() : 0);
        return result;
    }


    public AppointmentEntity(int appointmentId, String calendar, String client, Byte isActive, String note, Byte repeats, String title, String todate, String venue, String whendate, String whentime, String totime, String companyRegNo) {
        this.appointmentId = appointmentId;
        this.calendar = calendar;
        this.client = client;
        this.isActive = isActive;
        this.note = note;
        this.repeats = repeats;
        this.title = title;
        this.todate = todate;
        this.venue = venue;
        this.whendate = whendate;
        this.whentime = whentime;
        this.totime = totime;
        this.companyRegNo = companyRegNo;
    }

    public AppointmentEntity() {
    }
}
