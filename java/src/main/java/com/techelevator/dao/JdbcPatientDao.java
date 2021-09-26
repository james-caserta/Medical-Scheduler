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
    public Patient getPatient(long patientId) {
        Patient patient = null;
        String sql = "SELECT patient_id, first_name, last_name, contact_number, city, state, zip, user_type " +
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
        String sql = "INSERT INTO patient (first_name, last_name, contact_number, city, state, zipcode) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING patient_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                patient.getFirstName(), patient.getLastName(), patient.getContactNumber(), patient.getCity(), patient.getState(), patient.getZip());

        return getPatient(newId);
    }

    @Override
    public Patient getUserType(String userType) {
        return null;
    }


    @Override
    public boolean create(String firstName, String lastName) {
        return false;
    }


// *** Patient MAP ***
    private Patient mapRowToPatient(SqlRowSet results) {
        Patient patient = new Patient();
        patient.setPatientId(results.getLong("patient_id"));
        patient.setFirstName(results.getString("first_name"));
        patient.setLastName(results.getString("last_name"));
        patient.setContactNumber(results.getString("contact_number"));
        patient.setUserType(results.getString("user_type"));
        patient.setCity(results.getString("city"));
        patient.setContactNumber(results.getString("contact_number"));
        patient.setZip(results.getString("zipcode"));
//        patient.setAccountUserType(results.getString("account_user_type"));
//        patient.setAccountId(results.getLong("accounts_id"));
//        patient.setEmail(results.getString("email"));
        return patient;
    }


    //    @Override
//    public void updatePatient(Patient patient) {
//        String sql = "UPDATE patient " +
//                "SET first_name = ?, last_name = ?, contact_number = ?, email = ? " +
//                "WHERE patient_id = ?;";
//        jdbcTemplate.update(sql, patient.getFirstName(), patient.getLastName(), patient.getContactNumber(), patient.getEmail());
//    }
//
//    @Override
//    public void deletePatient(long patientId) {
//        String sql = "DELETE FROM patient WHERE patient_id = ?;";
//        jdbcTemplate.update(sql, patientId);
//    }
}
