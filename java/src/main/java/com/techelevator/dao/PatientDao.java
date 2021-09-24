package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {

    Patient getPatientById(long patientId); // get the Patients Id
    // retrieve all info from patient with their id (firstname, lastname, email...)

    Patient getUserType(String userType); // user type being patient

    Patient getPatient(long patientId);

    Patient createPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(long patientId);



    boolean create(String firstName, String lastName);
}
