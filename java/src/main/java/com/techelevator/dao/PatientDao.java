package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {

    Patient getPatientById(long patientId); // get the Patients Id
    // retrieve all info from patient with their id (firstname, lastname, email...)

    Patient getUserType(String userType); // user type being patient

    Patient getFirstName(String firstName); // get firstName

    Patient getLastName(String lastName); // get Last name



    boolean create(String firstName, String lastName);
}
