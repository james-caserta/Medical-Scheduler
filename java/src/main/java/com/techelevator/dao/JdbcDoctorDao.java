package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public List<Doctor> getAllDoctorInfo(){
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * " +
                "(SELECT summary FROM doctor " +
                "UNION SELECT street_address, city, state, zip, consultation_fee FROM office " +
                "UNION SELECT first_name, last_name FROM account)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {

            String sql = "INSERT INTO doctor(doctor_id, summary, user_type, account_id) " +
                    "VALUES (?, ?, ?, ?) RETURNING doctor_id;";
            Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                     doctor.getDoctorId(), doctor.getSummary(), doctor.getUserType(), doctor.getAccountId());

            return getDoctor(newId);
    }

    @Override
    public Doctor getDoctor(long doctorId) {
        Doctor doctor = null;
        String sql = "SELECT doctor_id, account_id, user_type, summary " +
                "FROM doctor " +
                "WHERE doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public Doctor getDoctorByAccountId(long accountId) {
        Doctor doctor = null;
        String sql = "SELECT doctor_id, account_id, user_type, summary " +
                "FROM doctor " +
                "WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public Doctor getSummary(String summary) {
        Doctor doctor = null;
        String sql = "SELECT summary " +
                     "FROM doctor ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public boolean create(String firstName, String lastName, String officeName) {
        return false;
    }

    private Doctor mapRowToDoctor(SqlRowSet results) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(results.getLong("doctor_id"));
        doctor.setAccountId(results.getLong("account_id"));
        doctor.setUserType(results.getString("user_type"));
        doctor.setSummary(results.getString("summary"));

        return doctor;
    }
}
