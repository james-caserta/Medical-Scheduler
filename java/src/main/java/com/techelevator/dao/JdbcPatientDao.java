package com.techelevator.dao;


import com.techelevator.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPatientDao implements PatientDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Patient getPatientById(long patientId) {
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if(results.next()) {
            return mapRowToPatient(results);
        } else {
            throw new RuntimeException("Patient: "+patientId+" was not found.");
        }
    }

    @Override
    public Patient getPatient(long patientId) {
        Patient patient = null;
        String sql = "SELECT patient_id, account_id, user_type " +
                "FROM patient " +
                "WHERE patient_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            patient = mapRowToPatient(results);
        }
        return patient;
    }

    @Override
    public Patient createPatient(Patient patient) {
        String sql = "INSERT INTO patient (patient_id, account_id, user_type ) " +
                "VALUES (?, ?, ?,) RETURNING patient_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                patient.getPatientId(), patient.getAccountId(), patient.getUserType());

        return getPatient(newId);
    }


    @Override
    public boolean create(String firstName, String lastName) {
        return false;
    }


// *** Patient MAP ***
    private Patient mapRowToPatient(SqlRowSet results) {
        Patient patient = new Patient();
        patient.setPatientId(results.getLong("patient_id"));
        patient.setAccountId(results.getLong("accounts_id"));
        patient.setUserType(results.getString("user_type"));

        return patient;
    }
}
