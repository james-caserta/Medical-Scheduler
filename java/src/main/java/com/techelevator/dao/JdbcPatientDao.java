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
            throw new RuntimeException("patientId "+patientId+" was not found.");
        }
    }

    @Override
    public Patient getFirstName(String firstName) {
        return null;
    }

    @Override
    public Patient getLastName(String lastName) {
        return null;
    }

    @Override
    public boolean create(String firstName, String lastName) {
        return false;
    }


// *** MAP ***
    private Patient mapRowToPatient(SqlRowSet results) {
        Patient patient = new Patient();
        patient.setPatientId(results.getLong("patient_id"));
        patient.setFirstName(results.getString("first_name"));
        patient.setLastName(results.getString("last_name"));
        // patient.setContactNumber(results.getString("contact_number"));
        // patient.setEmail(results.getString("email"))
        // patient.setIsDoctor(results.getBoolean("is_doctor"));
        return patient;
    }
}
