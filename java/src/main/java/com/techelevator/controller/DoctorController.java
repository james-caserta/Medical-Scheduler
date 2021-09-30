package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.Account;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class DoctorController {

    private DoctorDao doctorDao;
    private UserDao userDao;
    private AccountDao accountDao;
    private DoctorAvailabilityDao doctorAvailabilityDao;
    private OfficeDao officeDao;

    public DoctorController(DoctorDao doctorDao, UserDao userDao, AccountDao accountDao, DoctorAvailabilityDao doctorAvailabilityDao,OfficeDao officeDao) {
        this.doctorDao = doctorDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.doctorAvailabilityDao = doctorAvailabilityDao;
        this.officeDao = officeDao;
    }

//  Create doctor
    @PreAuthorize("isAuthenticated")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/doctor/{id}", method = RequestMethod.POST)
    public Doctor createDoctor(@RequestBody Doctor doctor, @PathVariable("id") long doctorId) {
        return doctorDao.createDoctor(doctor);
    }

//  Get doctor by id
    @RequestMapping(path = "/doctor/{doctorId}", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable int doctorId){
        return doctorDao.getDoctor(doctorId);
    }


// Get ALL doctors
    @RequestMapping(path = "/allDoctors", method = RequestMethod.GET)
    public List<Doctor> findAllDoctors(){
        return doctorDao.findAllDoctors();
    }


// Get Doctor, Office, & Account info for Doctor Page
    @RequestMapping(path = "/doctorInfo", method = RequestMethod.GET)
    public List<Doctor> getAllDoctorInfo(){
        return doctorDao.getAllDoctorInfo();
    }



//   *******************************     ACCOUNT     *******************************************

// Create Account
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account){
        return accountDao.createAccount(account);
    }

// Get Account by id
    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public Account getAccount(@PathVariable long accountId){
        return accountDao.getAccountById(accountId);
    }


//  ***********************   OFFICE   ****************************


    /*Get all offices*/
    @RequestMapping(path = "/getAllOffices", method = RequestMethod.GET)
    public List<Office> getAllOffices(){
        return officeDao.getAllOffices();
    }

    /*Get Doctors by office id*/
    @RequestMapping(path = "/getDoctorsByOfficeId/{id}", method = RequestMethod.GET)
    public List<Account> getDoctorsByOfficeId(@PathVariable("id")  Long officeId){
        return doctorDao.getDoctorByOfficeId(officeId);
    }
    /*Get office by doctor id*/
    @RequestMapping(path = "/getOfficeByDoctorId/{id}", method = RequestMethod.GET)
    public Office getOfficeByDoctorId(@PathVariable("id") Long doctorId){
        return officeDao.getOfficeByDoctorId(doctorId);
    }


    /*Update Office information by Doctor Id*/
    @RequestMapping(path = "/updateDoctorOfficeInfo/{doctorId}", method = RequestMethod.PUT)
    public Office updateOfficeInfoByDoctorId(@RequestBody Office office, @PathVariable("doctorId") long doctorId){
        return officeDao.updateOfficeInfoByDoctorId(doctorId,office);
    }

    //Principal

    @RequestMapping(path = "/isDoctor", method = RequestMethod.GET)
    public boolean isDoctor(Principal principal){
        return doctorDao.isDoctor(principal.getName());

    }

    @RequestMapping(path = "/getDoctorPrincipal", method = RequestMethod.GET)
    public Doctor getDoctorPrincipal(Principal principal){
        return doctorDao.getDoctor(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/getAccountPrincipal", method = RequestMethod.GET)
    public Account getAccountPrincipal(Principal principal){
        return accountDao.getAccountByUserId(userDao.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/getOfficeDoctorPrincipal", method = RequestMethod.GET)
    public Office getOfficeDoctorPrincipal(Principal principal){
        return officeDao.getOfficeByDoctorId(getDoctorPrincipal(principal).getDoctorId());
    }

    @RequestMapping(path = "/getUserIDPrincipal", method = RequestMethod.GET)
    public long getUserIDPrincipal(Principal principal){
        return userDao.findByUsername(principal.getName()).getId();
    }

}
