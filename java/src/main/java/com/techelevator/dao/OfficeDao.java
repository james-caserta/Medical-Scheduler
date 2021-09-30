package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    Office getOfficeByDoctorId(Long doctorId);

    List<Office> getAllOffices();

    Office getOfficeInfoByOfficeId(long officeId);

    Office updateOfficeInfoByDoctorId(Long doctorId, Office office);

    void updateInfoByOfficeId(Office office);



}
