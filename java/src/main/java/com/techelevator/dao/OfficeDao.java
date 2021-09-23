package com.techelevator.dao;

import com.techelevator.model.Office;

public interface OfficeDao {

    Office updateInfoByOfficeId(long officeId);

    Office updateInfoByDoctorId(long doctorId);


}
