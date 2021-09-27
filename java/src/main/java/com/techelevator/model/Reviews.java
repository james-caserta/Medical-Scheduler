package com.techelevator.model;

import java.time.LocalDate;

public class Reviews {

    private long patientReviewId;
    private long patientId;

    private int overall_rating;
    private String review;
    private long doctorId;

    public long getPatientReviewId() {
        return patientReviewId;
    }

    public void setPatientReviewId(long patientReviewId) {
        this.patientReviewId = patientReviewId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public int getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(int overall_rating) {
        this.overall_rating = overall_rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
}
