package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("isAuthenticated()")
//@RequestMapping("patient")
@RestController
public class PatientController {

    private PatientDao patientDao;
    private UserDao userDao;


    // get all patients
//    @RequestMapping(path = "/patient", method = RequestMethod.GET)
//    public List<Patient> findALlPatients(){
//        return patientDao.findAllPatients();
//    }

    //get patient
    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable long patientId) {
        return patientDao.getPatient(patientId);
    }


    // create patient
    @RequestMapping( path = "/patient/{id}", method = RequestMethod.POST)
    public Patient addPatient(@RequestBody Patient patient, @PathVariable("id") long patientId) {
        return patientDao.createPatient(patient);
    }

    // update patient

    //delete patient


}
