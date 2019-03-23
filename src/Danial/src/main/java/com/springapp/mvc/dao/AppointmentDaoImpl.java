package com.springapp.mvc.dao;

import com.springapp.mvc.domain.AppointmentEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bruntha on 8/25/15.
 */
public class AppointmentDaoImpl implements AppointmentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(AppointmentEntity appointmentEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(appointmentEntity);

    }

    @Override
    public void edit(AppointmentEntity appointmentEntity) {
        sessionFactory.getCurrentSession().update(appointmentEntity);

    }

    @Override
    public void delete(int appointmentID) {
        sessionFactory.getCurrentSession().delete(getAppointment(appointmentID));

    }

    @Override
    public AppointmentEntity getAppointment(int appointmentID) {
        return (AppointmentEntity)sessionFactory.getCurrentSession().get(AppointmentEntity.class, appointmentID);

    }

    @Override
    public List getAllAppointments() {
        return sessionFactory.getCurrentSession().createQuery("from AppointmentEntity").list();

    }
}
