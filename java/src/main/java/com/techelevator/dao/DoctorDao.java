package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAllDoctors();

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctor(long userId);
<<<<<<< HEAD
=======

    List<Doctor> getAllDoctorInfo();
>>>>>>> eb84045f71ac8a7a926d834c0c61ca56e971bdb1

    Doctor getDoctorByAccountId(long accountId);

    Doctor getSummary(String summary);

    boolean create(String firstName, String lastName, String officeName);

    List<Account> getDoctorByOfficeId(Long officeId);

}
