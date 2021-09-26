--SELECT * FROM users
--JOIN account ON users.user_id = account.account_id
--JOIN doctor ON doctor.doctor_id = account.account_id


--INSERT INTO account(account_id,first_name,last_name,email,user_id)
--VALUES(3,'James','Leo','leo123',3);

--INSERT INTO DOCTOR
--INSERT INTO doctor(doctor_id,summary,practicing_from,user_type)
--VALUES(2,'This is richard the doctor','2020-04-15','doctor')


--INSERT INTO office (office_id,doctor_id,consulation_fee,street_address,city,state,county,zip)
--VALUES(1,1,200,'8305 OAK TREE RD','Raleigh','NC','Wake','27616')

--SELECT first_name, last_name, summary, practicing_from,consulation_fee,street_address,city,state,county,zip FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON office.office_id = doctor.doctor_id

--INSERT INTO doctor_availability (doctor_avalibility_id, office_doctor_id, day_of_week, start_time, end_time, availability)
--VALUES(1,1,'Monday','0700','1500','A')

--INSERT INTO users(username,password_hash,role)
--VALUES ('patient_test','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER')

--INSERT INTO patient (patient_id,contact_number,city,state,zipcode,user_type)
--VALUES(3,'','','','','')

--SELECT * FROM account
--JOIN patient ON account.account_id = patient.patient_id 

--SELECT * FROM users
--JOIN account ON users.user_id = account.account_id
--JOIN doctor ON doctor.doctor_id = account.account_id

--SELECT * FROM users 
--JOIN account ON users.user_id = account.account_id
--JOIN patient ON patient.patient_id = account.account_id

--SELECT * FROM users
--JOIN account ON users.user_id = account.account_id
--JOIN doctor ON doctor.doctor_id = account.account_id
--JOIN office ON office.office_id = doctor.doctor_id

--INSERT INTO patient_review (patient_review_id,patient_id,overall_rating,review,review_date,office_id)
--VALUES (1,3,5,'doctor Abdulla was very great and careful','2021-09-26',1)

--SELECT * FROM account
--JOIN patient ON account.account_id = patient.patient_id
--JOIN patient_review ON patient_review.patient_id = patient.patient_id

--INSERT INTO doctor_response (doctor_response_id,patient_review_id,response,response_date,office_doctor_id)
--VALUES(1,1,'Thank you so much James so you soon','2021-09-26',1)

--SELECT first_name, last_name, review, response FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON doctor.doctor_id = office.office_id
--JOIN patient_review ON patient_review.office_id = office.office_id
--JOIN doctor_response ON doctor_response.office_doctor_id = office.office_id

--SELECT first_name, last_name, review FROM account
--JOIN patient ON account.account_id = patient.patient_id
--JOIN patient_review ON patient_review.patient_id = patient.patient_id

--SELECT first_name, last_name, response FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON doctor.doctor_id = office.office_id
--JOIN doctor_response ON doctor_response.office_doctor_id = office.office_id