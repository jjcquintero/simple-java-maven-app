package com.springapp.mvc.dao;

import com.springapp.mvc.domain.AppointmentEntity;

import java.util.List;

/**
 * Created by bruntha on 8/25/15.
 */
public interface AppointmentDao {
    void insert(AppointmentEntity appointmentEntity);
    void edit(AppointmentEntity appointmentEntity);
    void delete(int appointmentID);
    AppointmentEntity getAppointment(int appointmentID);
    List getAllAppointments();
}
