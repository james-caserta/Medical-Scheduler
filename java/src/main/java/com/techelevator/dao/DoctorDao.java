package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAll();

    Doctor getDoctorById(long doctorID); // get the Doctors Id

    Doctor getUserType(String userType); // user is doctor

<<<<<<< HEAD
    Doctor getFirstName(String firstName); // get firstName

    Doctor getLastName(String lastName); // get Last name

=======
>>>>>>> 16d120d88be60e796811c93dcbbc212c6f8aebbe
    Doctor getSummary(String summary);

    boolean create(String firstName, String lastName, String officeName);

//    Doctor getOfficeName(String OfficeName); // Office ID that the doctor is linked

//    Doctor getFirstName(String firstName); // get firstName
//
//    Doctor getLastName(String lastName); // get Last name
}
