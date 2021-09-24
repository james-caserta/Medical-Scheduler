package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentDao implements AppointmentDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Appointment createAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment getAppointment() {
        return null;
    }

    @Override
    public Appointment getAppointmentById(long appointmentId) {
        return null;
    }

// *** Appointment MAP ***
    private Appointment mapRowToAppointment(SqlRowSet results){
        Appointment appointment = new Appointment();
        appointment.setPatientId(results.getLong("patient_id"));
        appointment.setAppointmentId(results.getLong("appointment_id"));
        appointment.setOfficeId(results.getLong("office_id"));
        appointment.setStartTime(results.getString("start_time"));
        appointment.setEndTime(results.getString("end_time"));
        appointment.setAppointmentStatusId(results.getLong("appointment_status_id"));
        appointment.setAppointmentDate(results.getDate("appointment_date").toLocalDate());

        return appointment;
    }
}
