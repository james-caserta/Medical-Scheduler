package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAll();

    Doctor getDoctorById(long doctorID); // get the Doctors Id

    Doctor getOfficeName(String OfficeName); // Office ID that the doctor is linked

    Doctor getUserType(String userType); // user type being doctor

    Doctor getfirstName(String firstName); // get firstName

    Doctor getlastName(String lastName); // get Last name

    boolean create(String firstName, String lastName, String officeName);

}