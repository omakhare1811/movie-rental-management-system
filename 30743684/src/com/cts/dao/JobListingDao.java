package com.cts.dao;

import com.cts.exception.DatabaseException;
import com.cts.modal.JobListingModal;

import java.util.List;

public interface JobListingDao {
    void addJobListing(JobListingModal jobListing) throws DatabaseException;
    List<JobListingModal> getAllJobListings() throws DatabaseException;
    void updateJobListing(JobListingModal jobListing) throws DatabaseException;
    void deleteJobListing(int jobId) throws DatabaseException;
}
