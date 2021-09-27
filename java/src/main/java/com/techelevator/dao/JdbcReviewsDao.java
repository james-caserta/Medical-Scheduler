package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewsDao implements ReviewsDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcReviewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reviews> findAllReviews() {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM patient_review";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Reviews review = mapRowToReviews(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Reviews getReviewByPatientId(long patientId) {
        String sql = "SELECT * " +
                "FROM patient_review " +
                "WHERE patient_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if(results.next()) {
            return mapRowToReviews(results);
        } else {
            throw new RuntimeException("Patient Id "+patientId+" was not found.");
        }
    }

    @Override
    public Reviews getReviewByOfficeId(long officeId) {
        String sql = "SELECT * " +
                "FROM patient_review " +
                "WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if(results.next()) {
            return mapRowToReviews(results);
        } else {
            throw new RuntimeException("Office Id "+officeId+" was not found.");
        }
    }

    @Override
    public Reviews getReviews(long patientReviewId) {
        Reviews reviews = null;
        String sql = "SELECT patient_review_id, patient_id, overall_rating, review, doctor_id " +
                "FROM patient_review " +
                "WHERE patient_review_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientReviewId);
        if (results.next()) {
            reviews = mapRowToReviews(results);
        }
        return reviews;
    }

    @Override
    public Reviews createReview(Reviews reviews) {
        String sql = "INSERT INTO patient_review (patient_id, overall_rating, review, doctor_id) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING patient_review_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, reviews.getPatientId(), reviews.getReviewRating(),
                reviews.getReview(), reviews.getDoctorId());

        return getReviews(newId);
    }


    // *** MAP ***
    private Reviews mapRowToReviews(SqlRowSet results){
        Reviews reviews = new Reviews();
        reviews.setPatientId(results.getLong("patient_id"));
        reviews.setDoctorId(results.getLong("doctor_id"));
        reviews.setReviewRating(results.getInt("overall_rating"));
        reviews.setPatientReviewId(results.getInt("patient_review_id"));
        reviews.setReview(results.getString("review"));

        return reviews;
    }
}

