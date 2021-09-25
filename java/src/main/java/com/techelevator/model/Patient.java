package com.techelevator.model;

public class Patient {

    private long patientId;
<<<<<<< HEAD
    private String userType;
=======
    private String accountUserType;
>>>>>>> f2fa5c13a3f669c3a9d7b526c121070f1d2078c4
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String contactNumber;
    //    private String email;
    //    private long accountId;


// Getter and Setter
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

<<<<<<< HEAD
=======
    public String getAccountUserType() {
        return accountUserType;
    }
    public void setAccountUserType(String accountUserType) {
        this.accountUserType = accountUserType;
    }

>>>>>>> f2fa5c13a3f669c3a9d7b526c121070f1d2078c4
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

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

//    public String getUserType() {
//        return userType;
//    }
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
