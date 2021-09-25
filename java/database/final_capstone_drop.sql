-- foreign keys
ALTER TABLE appointment
    DROP CONSTRAINT appointment_patient;

ALTER TABLE appointment_status
    DROP CONSTRAINT appointment_status_appointment;

ALTER TABLE doctor_availability
    DROP CONSTRAINT doctor_availability_office;

ALTER TABLE doctor_response
    DROP CONSTRAINT doctor_response_office;

ALTER TABLE doctor_response
    DROP CONSTRAINT doctor_response_patient_review;

ALTER TABLE doctor
    DROP CONSTRAINT doctor_users;

ALTER TABLE office
    DROP CONSTRAINT office_doctor;

ALTER TABLE patient_review
    DROP CONSTRAINT patient_review_office;

ALTER TABLE patient_review
    DROP CONSTRAINT patient_review_patient;

ALTER TABLE patient
    DROP CONSTRAINT patient_users;

-- tables
DROP TABLE appointment;

DROP TABLE appointment_status;

DROP TABLE doctor;

DROP TABLE doctor_availability;

DROP TABLE doctor_response;

DROP TABLE office;

DROP TABLE patient;

DROP TABLE patient_review;

DROP TABLE users;

-- sequences
DROP SEQUENCE IF EXISTS seq_user_id;

-- End of file.

