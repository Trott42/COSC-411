CREATE DATABASE resume_scanner;

USE resume_scanner;

CREATE TABLE CANDIDATE (
    Candidate_ID INT PRIMARY KEY,
    Fname VARCHAR(255),
    Lname VARCHAR(255),
    Phone_num VARCHAR(20),
    Email VARCHAR(255) UNIQUE,
    Hpassword VARCHAR(255),
    Addr VARCHAR(255),
    City VARCHAR(255),
    State VARCHAR(50),
    Zipcode VARCHAR(20),
    Res_ID INT,
    App_ID INT
);

CREATE TABLE EMPLOYER (
    Employer_ID INT PRIMARY KEY,
    Fname VARCHAR(255),
    Lname VARCHAR(255),
    Phone_num VARCHAR(20),
    Hpassword VARCHAR(255),
    Email VARCHAR(255) UNIQUE
);

CREATE TABLE APPLICATION (
    Application_ID INT PRIMARY KEY,
    CanID INT,
    ResID INT,
    EmpID INT,
    Date_Submitted DATE,
    Date_Updated DATE,
    Application_Status VARCHAR(50),
    UserEmail VARCHAR(255) UNIQUE
);

CREATE TABLE RESUME (
    Resume_ID INT PRIMARY KEY,
    C_ID INT,
    A_ID INT
    -- Resume will match training data attributes
);

-- CREATE TABLE TRAINING_DATA (
    -- We don't have training data yet
-- );

-- Need to make HAS and SENDS relationships (probably)

ALTER TABLE CANDIDATE
ADD FOREIGN KEY (Res_ID) REFERENCES RESUME(Resume_ID),
ADD FOREIGN KEY (App_ID) REFERENCES APPLICATION(Application_ID);

ALTER TABLE APPLICATION
ADD FOREIGN KEY (ResID) REFERENCES RESUME(Resume_ID),
ADD FOREIGN KEY (CanID) REFERENCES CANDIDATE(Candidate_ID),
ADD FOREIGN KEY (EmpID) REFERENCES EMPLOYER(Employer_ID);

ALTER TABLE RESUME
ADD FOREIGN KEY (C_ID) REFERENCES CANDIDATE(Candidate_ID),
ADD FOREIGN KEY (A_ID) REFERENCES APPLICATION(Application_ID);

-- Adding sample data
INSERT INTO CANDIDATE VALUE(123, "Luke", "Thacker", "616-295-8961", "lthacke3@emich.edu", "root123", "950 Railroad Street", "Ypsilanti", "MI", "48197", null, null);
