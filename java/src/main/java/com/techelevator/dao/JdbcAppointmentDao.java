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
        String sql = "INSERT INTO appointment (patientId, officeId, start_date, end_date, doctor_id, description) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING appointment_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                appointment.getPatientId(), appointment.getOfficeId(), appointment.getStartDate(), appointment.getEndDate(),
                appointment.getDoctorId(), appointment.getDescription());

        return getAppointment(newId);
    }

    @Override
    public Appointment getAppointment(long appointmentId) {
        Appointment appointment = null;
        String sql = "SELECT appointment_id, patient_id, office_id, start_date, end_date, doctor_id, description " +
                "FROM appointment " +
                "WHERE appointment_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
        if (results.next()) {
            appointment = mapRowToAppointment(results);
        }
        return appointment;
    }

    @Override
    public Appointment getAppointmentById(long appointmentId) {
        String sql = "SELECT * FROM appointment WHERE appointment_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
        if(results.next()) {
            return mapRowToAppointment(results);
        } else {
            throw new RuntimeException("Appointment id " + appointmentId + " was not found.");
        }
    }

// *** Appointment MAP ***
    private Appointment mapRowToAppointment(SqlRowSet results){
        Appointment appointment = new Appointment();
        appointment.setPatientId(results.getLong("patient_id"));
        appointment.setAppointmentId(results.getLong("appointment_id"));
        appointment.setOfficeId(results.getLong("office_id"));
        appointment.setStartDate(results.getString("start_date"));
        appointment.setEndDate(results.getString("end_date"));
        appointment.setDoctorId(results.getLong("doctor_id"));
        appointment.setDescription(results.getString("description"));

        return appointment;
    }
}
