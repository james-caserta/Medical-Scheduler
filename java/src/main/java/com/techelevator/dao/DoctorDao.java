package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAll();

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctor(long doctorId); // get the Doctors Id

    Doctor getUserType(String userType); // user is doctor

    Doctor getFirstName(String firstName); // get firstName

    Doctor getLastName(String lastName); // get Last name

    Doctor getSummary(String summary);

    boolean create(String firstName, String lastName, String officeName);

//    Doctor getOfficeName(String OfficeName); // Office ID that the doctor is linked

//    Doctor getFirstName(String firstName); // get firstName
//
//    Doctor getLastName(String lastName); // get Last name
}
