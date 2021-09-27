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
    public Doctor createDoctor(Doctor doctor) {
            String sql = "INSERT INTO doctor (doctor_id, account_id, user_type, summary ) " +
                    "VALUES (?, ?, ?, ?) RETURNING doctor_id;";
            Long newId = jdbcTemplate.queryForObject(sql, Long.class, doctor.getDoctorId(), doctor.getAccountId(),
                    doctor.getUserType(), doctor.getSummary());


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
        //        doctor.setFirstName(results.getString("first_name"));
        //        doctor.setLastName(results.getString("last_name"));
        //        doctor.setOfficeName(results.getString("office_id"));
        return doctor;
    }
}
