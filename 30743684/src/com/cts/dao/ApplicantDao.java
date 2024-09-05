package com.cts.dao;

import com.cts.exception.DatabaseException;
import com.cts.modal.ApplicantModal;

import java.util.List;

public interface ApplicantDao {
    void addApplicant(ApplicantModal applicant) throws DatabaseException;
    List<ApplicantModal> getAllApplicants() throws DatabaseException;
    void updateApplicant(ApplicantModal applicant) throws DatabaseException;
    void deleteApplicant(int applicantId) throws DatabaseException;
}
