
DROP TABLE users CASCADE;
DROP TABLE doctor CASCADE;
DROP TABLE account CASCADE;
DROP TABLE patient CASCADE;
DROP TABLE office CASCADE;
DROP TABLE patient_review CASCADE;
DROP TABLE appointment CASCADE;

CREATE TABLE users (
    --user_id serial  NOT NULL DEFAULT nextval( 'seq_user_id' :: regclass ),
    user_id serial,
    username varchar(50)  NOT NULL,
    password_hash varchar(200)  NOT NULL,
    role varchar(50)  NOT NULL,
    is_doctor boolean NOT NULL,
    --CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES account(user_id),
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE account (
    account_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(50)  NOT NULL,
    user_id int,
    CONSTRAINT user_fk FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT account_pk PRIMARY KEY (account_id)
);

CREATE TABLE doctor (
    doctor_id int  NOT NULL,
    summary varchar(500)  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT doctor_pk PRIMARY KEY (doctor_id)
);

-- Table: patient
CREATE TABLE patient (
    patient_id int  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT patient_pk PRIMARY KEY (patient_id)
); 

-- Table: office
CREATE TABLE office (
    office_id serial,
    doctor_id int,
    phone_number BIGINT,
    street_address varchar(100)  NOT NULL,
    city varchar(100)  NOT NULL,
    state varchar(100)  NOT NULL,
    zip varchar(50)  NOT NULL,
    consultation_fee int,
    CONSTRAINT doctor_fk FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT office_pk PRIMARY KEY (office_id)
);

-- Table: patient_review
CREATE TABLE patient_review (
    patient_review_id serial,
    patient_id int  NOT NULL,
    overall_rating int  NOT NULL,
    review varchar(500)  NOT NULL,
    doctor_id int  NOT NULL,
    CONSTRAINT doctor_fk FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT patient_review_pk PRIMARY KEY (patient_review_id)
);

-- Table: appointment
CREATE TABLE appointment (
    appointment_id serial,
    patient_id int  NOT NULL,
    description varchar(500)  NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    doctor_id int  NOT NULL,
    office_id int NOT NULL,
    CONSTRAINT office_id_fk FOREIGN KEY(office_id) REFERENCES office(office_id),
    CONSTRAINT doctor_id_fk FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT appointment_id_pk PRIMARY KEY (appointment_id)
);

-- Creates Users/Accounts
-- UPDATE HASH TO A KNOWN password!!!!
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('JamesC','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('AbdullaT','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('AJP','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('YousefK','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('BobB','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('JohnS','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('RonaldM','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_doctor) VALUES ('JoeG','$2a$10$WVGvp9WcNDRJoKdqFLL5Ne6uByFDrVAw2jHKj3ll96NqR411wJVsy','ROLE_USER', true);


INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(1,'James','Caserta','JC@gmail.com',1);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(2,'Abdulla','Treek','AT@gmail.com',2);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(3,'AJ','Page','AP@gmail.com',3);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(4,'Yousef','Khudair','YK@gmail.com',4);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(5,'Bob','Bobert','BR@gmail.com',5);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(6,'John','Sulton','JS@gmail.com',6);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(7,'Ronald','McJohnald','RM@gmail.com',7);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(8,'Joe','Green','JG@gmail.com',8);

-- Creates Patients
INSERT INTO patient(patient_id,user_type, account_id) VALUES(1,'patient',1);
INSERT INTO patient(patient_id,user_type, account_id) VALUES(4,'patient',4);

--Creates Doctors
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(2,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',2);
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(3,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',3);
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(5,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',3);
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(6,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',3);
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(7,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',3);
INSERT INTO doctor(doctor_id, summary, user_type, account_id) VALUES(8,'Medical doctor in respected regional medical hospital. Provided personalized service to maximize patient outcomes and satisfaction. Contributed to 20% boost in HCAHPS scores through effective communication with nursing and administrative staff. Facilitated 15% reduction in costs for supplies and staffing thanks to application of lean medical principles. Maintained 85% success rate for patient goal attainment as measured by annual follow-up calls and surveys.','doctor',3);
--Creates Offices
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(2, 9023935930,'123 Seaview Ave', 'BK', 'NY', 10301, 100);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(2,6468382345, '4567 Court St', 'LA', 'CA', 90210, 125);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(3, 9023967890,'2st Ave', 'BK', 'NY', 10301, 100);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(5,1347382992, '63rd St', 'LA', 'CA', 90210, 125);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(5, 9863743930,'92st st', 'BK', 'NY', 10301, 100);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(6,6468368892, 'Avenue F #1223', 'LA', 'CA', 90210, 125);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(7, 9023247930,'101 Bushwick Ave', 'BK', 'NY', 10301, 100);
INSERT INTO office( doctor_id, phone_number, street_address, city, state, zip, consultation_fee) VALUES(8,6468375392, '69 Pool St', 'LA', 'CA', 90210, 125);

--Creates Office Review

INSERT INTO patient_review(patient_review_id, patient_id, overall_rating, review, doctor_id) VALUES(1,4,2,'I had a great experience with my doctor and this office!', 5);
INSERT INTO patient_review(patient_review_id, patient_id, overall_rating, review, doctor_id) VALUES(4,3,2,'Clean office and easy parking.', 5);

--Creates Appointments

INSERT INTO appointment(patient_id, description, start_date, end_date, doctor_id, office_id) VALUES (1, 'Annual Check-up', '2021-05-03T20:15:00.000Z', '2021-05-03T23:15:00.000Z', 2, 2);



CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;