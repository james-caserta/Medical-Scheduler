package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Doctor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
//@RequestMapping("doctor")
public class DoctorController {

    private DoctorDao doctorDao;
    private UserDao userDao;

    public DoctorController(DoctorDao doctorDao, UserDao userDao) {
        this.doctorDao = doctorDao;
        this.userDao = userDao;
    }

//  Create doctor
    @PreAuthorize("isAuthenticated")
    @RequestMapping( path = "/doctor/{id}", method = RequestMethod.POST)
    public Doctor createDoctor(@RequestBody Doctor doctor, @PathVariable("id") long doctorId) {
        return doctorDao.createDoctor(doctor);
    }

//  Get doctor by id
    @RequestMapping(path = "doctor", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable long doctorId){
        return doctorDao.getDoctor(doctorId);
    }



}
