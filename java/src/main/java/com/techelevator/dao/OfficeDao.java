package com.techelevator.dao;

import com.techelevator.model.Office;

public interface OfficeDao {

    void updateInfoByOfficeId(Office office);

    void updateInfoByDoctorId(Office office);


}
