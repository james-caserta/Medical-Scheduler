package com.techelevator.model;

import java.time.LocalDate;

public class Doctor {

    private long doctorId;
    private long accountId;
    private String userType;
    private String summary;





// Getter and Setter
    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }


    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }


}

