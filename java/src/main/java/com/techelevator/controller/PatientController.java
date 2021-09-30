package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class PatientController {

    private PatientDao patientDao;
    private UserDao userDao;

    public PatientController(PatientDao patientDao, UserDao userDao) {
        this.patientDao = patientDao;
        this.userDao = userDao;
    }

    //get patient
    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable long patientId) {
        return patientDao.getPatient(patientId);
    }


    // create patient
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/patient/{id}", method = RequestMethod.POST)
    public Patient addPatient(@RequestBody Patient patient, @PathVariable("id") long patientId) {
        return patientDao.createPatient(patient);
    }

}
