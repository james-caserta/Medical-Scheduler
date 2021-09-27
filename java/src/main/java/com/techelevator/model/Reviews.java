package com.techelevator.model;

import java.time.LocalDate;

public class Reviews {

    private long patientId;
    private long doctorId;
    private int reviewRating;
    private long patientReviewId;
    private String review;


    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public int getReviewRating() {
        return reviewRating;
    }
    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public long getPatientReviewId() {
        return patientReviewId;
    }
    public void setPatientReviewId(int patientReviewId) {
        this.patientReviewId = patientReviewId;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

}
