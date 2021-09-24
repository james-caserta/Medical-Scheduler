package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentStatusDao implements AppointmentStatusDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcAppointmentStatusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public AppointmentStatus getAppointmentStatusById(long appointmentId) {
        return null;
    }

//  ***Appointment Status MAP ***
    private AppointmentStatus mapRowToAppointmentStatus(SqlRowSet results){
        AppointmentStatus appointmentStatus = new AppointmentStatus();
        appointmentStatus.setAppointmentStatusId(results.getLong("appointment_status_id"));
        appointmentStatus.setAppointmentId(results.getLong("appointment_id"));
        appointmentStatus.setStatus(results.getLong("status"));

        return appointmentStatus;
    }
}
