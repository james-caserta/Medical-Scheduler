package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAllDoctors();

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctor(long userId);

    List<Doctor> getAllDoctorInfo();

    Doctor getDoctorByAccountId(long accountId);

    Doctor getSummary(String summary);

    boolean create(String firstName, String lastName, String officeName);

    List<Account> getDoctorByOfficeId(Long officeId);

    boolean isDoctor(String username);

}
