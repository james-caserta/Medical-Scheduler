package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.AppointmentStatusDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalendarController {
    private AppointmentDao appointmentDao;
    private AppointmentStatusDao appointmentStatusDao;

    public CalendarController(AppointmentDao appointmentDao, AppointmentStatusDao appointmentStatusDao) {
        this.appointmentDao = appointmentDao;
        this.appointmentStatusDao = appointmentStatusDao;
    }

// Create Appointment
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/appointment/{id}", method = RequestMethod.POST)
    public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable("id") long appointmentId) {
        return appointmentDao.createAppointment(appointment);
    }

// Get Appointment
    @RequestMapping(path = "/appointment", method = RequestMethod.GET)
    public Appointment getAppointment(@PathVariable long appointmentId){
        return appointmentDao.getAppointmentById(appointmentId);
    }

// Create Appointment Status
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/appointmentStatus/{id}", method = RequestMethod.POST)
    public AppointmentStatus createAppointmentStatus(@RequestBody AppointmentStatus appointmentStatus, @PathVariable("id") long appointmentStatusId) {
        return appointmentStatusDao.createAppointmentStatus(appointmentStatus);
    }

// Get Appointment Status
    @RequestMapping(path = "/appointmentStatus", method = RequestMethod.GET)
    public AppointmentStatus getAppointmentStatus(@PathVariable long appointmentStatusId){
        return appointmentStatusDao.getAppointmentStatusById(appointmentStatusId);
    }



}
