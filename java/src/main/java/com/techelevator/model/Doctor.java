package com.techelevator.model;

import java.time.LocalDate;

public class Doctor {

    private long doctorId;
    private String firstName;
    private String lastName;
    private String userType;
    private String summary;
    private LocalDate practicingFrom;
//    private String accountUserType;
    private int accountId;




// Getter and Setter
    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalDate getPracticingFrom() {
        return practicingFrom;
    }
    public void setPracticingFrom(LocalDate practicingFrom) {
        this.practicingFrom = practicingFrom;
    }

//    public String getAccountUserType() {
//        return accountUserType;
//    }
//    public void setAccountUserType(String accountUserType) {
//        this.accountUserType = accountUserType;
//    }
}

