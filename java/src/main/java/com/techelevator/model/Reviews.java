package com.techelevator.model;

import java.time.LocalDate;

public class Reviews {

    private long patientId;
    private long doctorId;
    private int overall_rating;
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

    public int getOverall_rating() {
        return overall_rating;
    }
    public void setOverall_rating(int overall_rating) {
        this.overall_rating = overall_rating;
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
