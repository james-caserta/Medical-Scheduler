package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    List<Reviews> findAllReviews();

    Reviews getReviewByPatientId(long patientId);

    Reviews getReviewByPatientName(String firstName, String lastName);

    Reviews getReviewByOfficeId(long officeId);
}
