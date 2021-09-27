package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {

    Patient getPatientById(long patientId);

    Patient getPatient(long patientId);

    Patient createPatient(Patient patient);

    boolean create(String firstName, String lastName);

}
