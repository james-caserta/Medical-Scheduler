package com.techelevator.controller;


import com.techelevator.dao.AccountDao;
import com.techelevator.dao.DoctorAvailabilityDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Account;
import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorAvailability;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class DoctorController {

    private DoctorDao doctorDao;
    private UserDao userDao;
    private AccountDao accountDao;
    private DoctorAvailabilityDao doctorAvailabilityDao;

    public DoctorController(DoctorDao doctorDao, UserDao userDao, AccountDao accountDao, DoctorAvailabilityDao doctorAvailabilityDao) {
        this.doctorDao = doctorDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.doctorAvailabilityDao = doctorAvailabilityDao;
    }

//  Create doctor
    @PreAuthorize("isAuthenticated")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/doctor/{id}", method = RequestMethod.POST)
    public Doctor createDoctor(@RequestBody Doctor doctor, @PathVariable("id") long doctorId) {
        return doctorDao.createDoctor(doctor);
    }

//  Get doctor by id
    @RequestMapping(path = "doctor", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable long doctorId){
        return doctorDao.getDoctor(doctorId);
    }


// Get ALL doctors
    @RequestMapping(path = "/allDoctors", method = RequestMethod.GET)
    public List<Doctor> findAllDoctors(){
        return doctorDao.findAllDoctors();
    }


//    ******  Availability  ******


// Get Doctor Availability
    @RequestMapping(path = "/availability", method = RequestMethod.GET)
    public DoctorAvailability getAvailability(@PathVariable long doctorAvailabilityId){
        return doctorAvailabilityDao.getDoctorAvailability(doctorAvailabilityId);
    }


//    *******   ACCOUNT   *********

// Create Account
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account/{id}", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account, @PathVariable("id") long accountId){
        return accountDao.createAccount(account);
    }

// Get Account by Id
    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public Account getAccount(@PathVariable long accountId){
        return accountDao.getAccountById(accountId);
    }


}
