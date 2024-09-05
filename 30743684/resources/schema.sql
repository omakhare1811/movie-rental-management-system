CREATE DATABASE job_portal;

USE job_portal;

CREATE TABLE JobListing (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    requirements TEXT,
    posted_date DATE,
    status ENUM('active', 'inactive')
);

CREATE TABLE Applicant (
    applicant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address TEXT
);

CREATE TABLE Interview (
    interview_id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT,
    applicant_id INT,
    interview_date DATETIME,
    status ENUM('scheduled', 'completed', 'cancelled'),
    FOREIGN KEY (job_id) REFERENCES JobListing(job_id),
    FOREIGN KEY (applicant_id) REFERENCES Applicant(applicant_id)
);
