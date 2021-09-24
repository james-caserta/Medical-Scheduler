package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("doctor")
public class DoctorController {

    private DoctorDao doctorDao;
    private UserDao userDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public long getDoctor(){
        return 0;
    }

}
