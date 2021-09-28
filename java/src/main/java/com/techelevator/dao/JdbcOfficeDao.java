package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Office getOfficeByDoctorId(Long doctorId) {
        Office office = null;
        String sql = "SELECT office_id, doctor_id, street_address, city, state, zip " +
                "FROM office " +
                "WHERE doctor_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, doctorId);
        if (result.next()) {
            office = mapRowToOffice(result);
        }
        return office;
    }

    @Override
    public List<Office> getAllOffices(){
        List<Office> officeList = new ArrayList<Office>();
        String sql= "SELECT office_id, doctor_id, street_address, city, state, zip FROM office ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Office office = mapRowToOffice(results);
            officeList.add(office);
        }
        return officeList;
    }

    @Override
    public Office getOfficeInfoByOfficeId(long officeId) {
        Office office = null;
        String sql = "SELECT street_address, city, state, zip, consultation_fee " +
                "FROM office " +
                "WHERE office_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if (result.next()) {
            office = mapRowToOffice(result);
        }
        return office;
    }

    @Override
    public void updateInfoByOfficeId(Office office) {
        String sql = "UPDATE office " +
                "SET street_address = ?, city = ?, state = ?, zip = ?" +
                "WHERE office_id = ?;";
        jdbcTemplate.update(sql, office.getStreetAddress(), office.getCity(), office.getState(),
                office.getZip());
    }

    @Override
    public void updateInfoByDoctorId(Office office) {
        String sql = "UPDATE office " +
                "SET street_address = ?, city = ?, state = ?, zip = ?" +
                "WHERE doctor_id = ?;";
        jdbcTemplate.update(sql, office.getStreetAddress(), office.getCity(), office.getState(),
                office.getZip());
    }


    private Office mapRowToOffice(SqlRowSet results) {
        Office office = new Office();
        office.setOfficeId(results.getLong("office_id"));
        office.setDoctorId(results.getLong("doctor_id"));
        office.setStreetAddress(results.getString("street_address"));
        office.setCity(results.getString("city"));
        office.setState(results.getString("state"));
        office.setZip(results.getString("zip"));
        return office;
    }
}
