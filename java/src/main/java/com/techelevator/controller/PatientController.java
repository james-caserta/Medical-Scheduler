package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RequestMapping("patient")
@RestController
public class PatientController {

    //private PatientDao patientDao;
    private UserDao userDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public long getPatient(){
        return 0;
    }
}