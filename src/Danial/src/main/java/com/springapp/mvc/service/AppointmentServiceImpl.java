package com.springapp.mvc.service;

import com.springapp.mvc.dao.AppointmentDao;
import com.springapp.mvc.domain.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bruntha on 8/26/15.
 */
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    @Transactional
    public void insert(AppointmentEntity appointmentEntity) {
        appointmentDao.insert(appointmentEntity);

    }

    @Override
    @Transactional
    public void edit(AppointmentEntity appointmentEntity) {
        appointmentDao.edit(appointmentEntity);

    }

    @Override
    @Transactional
    public void delete(int appointmentID) {
        appointmentDao.delete(appointmentID);

    }

    @Override
    @Transactional
    public AppointmentEntity getAppointment(int appointmentID) {
        return appointmentDao.getAppointment(appointmentID);

    }

    @Override
    @Transactional
    public List getAllAppointments() {
        return appointmentDao.getAllAppointments();
    }
}
