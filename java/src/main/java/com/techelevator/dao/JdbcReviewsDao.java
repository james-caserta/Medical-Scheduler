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
        String sql = "SELECT * FROM patient_review";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Reviews review = mapRowToReviews(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Reviews getReviewByPatientId(long patientId) {
        String sql = "SELECT * FROM reviews WHERE patient_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if(results.next()) {
            return mapRowToReviews(results);
        } else {
            throw new RuntimeException("patientId "+patientId+" was not found.");
        }
    }

    @Override
    public Reviews getReviewByOfficeId(long officeId) {
        String sql = "SELECT * FROM reviews WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if(results.next()) {
            return mapRowToReviews(results);
        } else {
            throw new RuntimeException("officeId "+officeId+" was not found.");
        }

    }

    @Override
    public Reviews getReviews(long patientReviewId) {
        Reviews reviews = null;
        String sql = "SELECT patient_review_id, patient_id, overall_rating, review, review_date, office_id " +
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
        String sql = "INSERT INTO patient_review (patient_review_id, patient_id, overall_rating, review, review_date, office_id) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING patient_review_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, reviews.getPatientReviewId(), reviews.getPatientId(), reviews.getReviewRating(),
                reviews.getReview(), reviews.getReviewDate(), reviews.getOfficeId());

        return getReviews(newId);
    }

    @Override
    public void updateReview(Reviews reviews) {
        String sql = "UPDATE patient_review " +
                "SET overall_rating = ?, review = ?, review_date = ? " +
                "WHERE patient_review_id = ?;";
        jdbcTemplate.update(sql, reviews.getReviewRating(), reviews.getReview(), reviews.getReviewDate());
    }

    @Override
    public void deleteReview(long patientReviewId) {
        String sql = "DELETE FROM patient_review WHERE patient_review_id = ?;";
        jdbcTemplate.update(sql, patientReviewId);
    }

    @Override
    public Reviews getReviewByPatientName(String firstName, String lastName) {

        return null;
    }




    // *** MAP ***
    private Reviews mapRowToReviews(SqlRowSet results){
        Reviews reviews = new Reviews();
        reviews.setPatientId(results.getLong("patient_id"));
        reviews.setOfficeId(results.getLong("office_id"));
        reviews.setReviewRating(results.getInt("overall_rating"));
        reviews.setReviewDate(results.getDate("review_date").toLocalDate());
//        reviews.setPatientFirstName(results.getString("first_name"));
//        reviews.setPatientLastName(results.getString("last_name"));
        reviews.setPatientReviewId(results.getInt("patient_review_id"));
        reviews.setReview(results.getString("review"));

        return reviews;
    }
}
