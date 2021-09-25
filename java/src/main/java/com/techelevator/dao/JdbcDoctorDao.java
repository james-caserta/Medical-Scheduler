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
    public List<Doctor> findAll() {
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
    public Doctor createDoctor(Doctor doctor) {
            String sql = "INSERT INTO doctor (first_name, last_name, user_type, summary, practicing_from, account_user_type) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING doctor_id;";
            Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                    doctor.getFirstName(), doctor.getLastName(), doctor.getUserType(), doctor.getSummary(), doctor.getPracticingFrom(), doctor.getAccountUserType());

            return getDoctor(newId);
    }

    @Override
    public Doctor getDoctor(long doctorId) {
        Doctor doctor = null;
        String sql = "SELECT doctor_id, first_name, last_name, user_type, summary, practicing_from, account_user_type " +
                "FROM doctor " +
                "WHERE doctor_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public Doctor getUserType(String userType) {
        return null;
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
        doctor.setFirstName(results.getString("first_name"));
        doctor.setLastName(results.getString("last_name"));
        doctor.setUserType(results.getString("user_type"));
        doctor.setSummary(results.getString("summary"));
        doctor.setPracticingFrom(results.getDate("practicing_from").toLocalDate());
        doctor.setAccountUserType(results.getString("account_user_type"));
//        doctor.setOfficeName(results.getString("office_id"));
        return doctor;
    }

    //    @Override
//    public Doctor getOfficeName(String OfficeName) {
//        return null;
//    }

    //    @Override
//    public Doctor getFirstName(String firstName) {
//        return null;
//    }
//
//    @Override
//    public Doctor getLastName(String lastName) {
//        return null;
//    }

}
