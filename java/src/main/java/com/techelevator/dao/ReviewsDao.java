package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    List<Reviews> findAllReviews();

    Reviews getReviewByPatientId(long patientId);

    Reviews getReviewByDoctorId(long doctorId);

    Reviews getReviews(long patientReviewId);

    Reviews createReview(Reviews reviews);


//    void updateReview(Reviews reviews);
//    void deleteReview(long patientReviewId);
}
