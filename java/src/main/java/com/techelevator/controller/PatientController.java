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
<<<<<<< HEAD

    //delete patient

=======
//    @RequestMapping(path = "/patient/{id}", method = RequestMethod.PUT)
//    public Patient updatePatient(@Valid @RequestBody Patient patient, @PathVariable long patientId) {
//           return patientDao.updatePatient(patient, patientId);
//    }

    //delete patient
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/patient/{id}", method = RequestMethod.DELETE)
//    public void deletePatient(@PathVariable long patientId) {
//        patientDao.deletePatient(patientId);
//    }
>>>>>>> f2fa5c13a3f669c3a9d7b526c121070f1d2078c4

}
