package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.User;
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
    public Doctor getDoctorById(long doctorID) {
        return null;
    }

    @Override
    public Doctor getOfficeName(String OfficeName) {
        return null;
    }

    @Override
    public Doctor getIsDoctor(boolean isDoctor) {
        return null;
    }

    @Override
    public Doctor getFirstName(String firstName) {
        return null;
    }

    @Override
    public Doctor getLastName(String lastName) {
        return null;
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
        doctor.setOfficeName(results.getString("office_id"));
        doctor.setIsDoctor(results.getBoolean("is_doctor"));
//        doctor.setSummary(results.getString("summary"));
//        doctor.setPracticingFrom(results.getDate("practicing_from"));
//        doctor.setAccountId(results.getInt("account_id"));
        return doctor;
    }

}
