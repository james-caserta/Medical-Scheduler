package com.techelevator.model;

public class Patient {

    private long patientId;
    private long accountId;
    private String userType;


    // Getter and Setter
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getAccountId(){
        return accountId;
    }
    public void setAccountId(long patientId) {
        this.accountId = accountId;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

}

