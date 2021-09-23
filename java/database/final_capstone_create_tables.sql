--Tables
-- Table: accounts
CREATE TABLE accounts (
    account_id int  NOT NULL,
    user_id int  NOT NULL,
    is_doctor boolean  NOT NULL,
    CONSTRAINT accounts_pk PRIMARY KEY (account_id)
);

-- Table: appointment
CREATE TABLE appointment (
    appointment_id int  NOT NULL,
    patient_id int  NOT NULL,
    office_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    appointment_status_id int  NOT NULL,
    appoinment_date date  NOT NULL,
    CONSTRAINT appointment_pk PRIMARY KEY (appointment_id)
);

-- Table: appointment_status
CREATE TABLE appointment_status (
    appointment_status_id int  NOT NULL,
    status varchar(20)  NOT NULL,
    appointment_id int  NOT NULL,
    CONSTRAINT appointment_status_pk PRIMARY KEY (appointment_status_id)
);

-- Table: doctor
CREATE TABLE doctor (
    doctor_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    summary varchar(500)  NOT NULL,
    practicing_from date  NOT NULL,
    account_id int  NOT NULL,
    is_doctor Boolean(1)  NOT NULL,
    CONSTRAINT doctor_pk PRIMARY KEY (doctor_id)
);

-- Table: doctor_availability
CREATE TABLE doctor_availability (
    doctor_avalibility_id int  NOT NULL,
    office_doctor_id int  NOT NULL,
    day_of_week varchar(10)  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    availability char(1)  NOT NULL,
    CONSTRAINT doctor_availability_pk PRIMARY KEY (doctor_avalibility_id)
);

-- Table: doctor_response
CREATE TABLE doctor_response (
    doctor_response_id int  NOT NULL,
    patient_review_id int  NOT NULL,
    response varchar(500)  NOT NULL,
    response_date date  NOT NULL,
    office_doctor_id int  NOT NULL,
    CONSTRAINT doctor_response_pk PRIMARY KEY (doctor_response_id)
);

-- Table: office
CREATE TABLE office (
    office_id int  NOT NULL,
    doctor_id int  NOT NULL,
    consulation_fee int  NOT NULL,
    street_address varchar(100)  NOT NULL,
    city varchar(100)  NOT NULL,
    state varchar(100)  NOT NULL,
    county varchar(100)  NOT NULL,
    zip varchar(50)  NOT NULL,
    CONSTRAINT office_pk PRIMARY KEY (office_id)
);

-- Table: patient
CREATE TABLE patient (
    patient_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    contact_number varchar(11)  NOT NULL,
    email varchar(50)  NOT NULL,
    accounts_id int  NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (patient_id)
);

-- Table: patient_review
CREATE TABLE patient_review (
    patient_review_id int  NOT NULL,
    patient_id int  NOT NULL,
    overall_rating int  NOT NULL,
    review varchar(500)  NOT NULL,
    review_date date  NOT NULL,
    office_id int  NOT NULL,
    CONSTRAINT patient_review_pk PRIMARY KEY (patient_review_id)
);

-- Table: users
CREATE TABLE users (
    user_id int  NOT NULL DEFAULT nextval( 'seq_user_id' :: regclass ),
    username varchar(50)  NOT NULL,
    password_hash varchar(200)  NOT NULL,
    role varchar(50)  NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: accounts_users (table: accounts)
ALTER TABLE accounts ADD CONSTRAINT accounts_users
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: appointment_patient (table: appointment)
ALTER TABLE appointment ADD CONSTRAINT appointment_patient
    FOREIGN KEY (patient_id)
    REFERENCES patient (patient_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: appointment_status_appointment (table: appointment_status)
ALTER TABLE appointment_status ADD CONSTRAINT appointment_status_appointment
    FOREIGN KEY (appointment_id)
    REFERENCES appointment (appointment_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_accounts (table: doctor)
ALTER TABLE doctor ADD CONSTRAINT doctor_accounts
    FOREIGN KEY (account_id)
    REFERENCES accounts (account_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_availability_office (table: doctor_availability)
ALTER TABLE doctor_availability ADD CONSTRAINT doctor_availability_office
    FOREIGN KEY (office_doctor_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_response_office (table: doctor_response)
ALTER TABLE doctor_response ADD CONSTRAINT doctor_response_office
    FOREIGN KEY (office_doctor_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_response_patient_review (table: doctor_response)
ALTER TABLE doctor_response ADD CONSTRAINT doctor_response_patient_review
    FOREIGN KEY (patient_review_id)
    REFERENCES patient_review (patient_review_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: office_doctor (table: office)
ALTER TABLE office ADD CONSTRAINT office_doctor
    FOREIGN KEY (doctor_id)
    REFERENCES doctor (doctor_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_accounts (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_accounts
    FOREIGN KEY (accounts_id)
    REFERENCES accounts (account_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_review_office (table: patient_review)
ALTER TABLE patient_review ADD CONSTRAINT patient_review_office
    FOREIGN KEY (office_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_review_patient (table: patient_review)
ALTER TABLE patient_review ADD CONSTRAINT patient_review_patient
    FOREIGN KEY (patient_id)
    REFERENCES patient (patient_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: seq_user_id
CREATE SEQUENCE seq_user_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1
      NO CYCLE
;

-- End of file.
