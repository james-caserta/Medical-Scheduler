package com.techelevator.model;

public class Doctor {

    private long doctorId;
    private String officeName;
    private String firstName;
    private String lastName;
    private boolean isDoctor;
    private String summary;
    private String practicingFrom;
    private int accountId;

    // ** calendar availability **
    // private String availability;


// Getter and Setter
    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getOfficeName() {
        return officeName;
    }
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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

    public boolean isDoctor() {
        return isDoctor;
    }
    public void setIsDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPracticingFrom() {
        return practicingFrom;
    }
    public void setPracticingFrom(String practicingFrom) {
        this.practicingFrom = practicingFrom;
    }

    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}

