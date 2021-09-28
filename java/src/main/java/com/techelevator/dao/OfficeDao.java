package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    Office getOfficeByDoctorId(Long doctorId);

    List<Office> getAllOffices();

    Office getOfficeInfoByOfficeId(long officeId);

    void updateInfoByOfficeId(Office office);

    void updateInfoByDoctorId(Office office);



}
