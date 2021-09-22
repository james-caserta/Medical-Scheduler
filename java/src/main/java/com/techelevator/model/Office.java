package com.techelevator.model;

public class Office {

    private long officeId;
    private long doctorId;
    private String address;
    private String phoneNumber;
    private String officeHours;
    private String costPerHour;


// Getter and Setter
    public long getOfficeId() {
        return officeId;
    }
    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getCostPerHour() {
        return costPerHour;
    }
    public void setCostPerHour(String costPerHour) {
        this.costPerHour = costPerHour;
    }
}
