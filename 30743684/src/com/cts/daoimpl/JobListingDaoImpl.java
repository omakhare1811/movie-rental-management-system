package com.cts.daoimpl;

import com.cts.dao.JobListingDao;
import com.cts.exception.DatabaseException;
import com.cts.modal.JobListingModal;
import com.cts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobListingDaoImpl implements JobListingDao {

    Connection connection;

    public JobListingDaoImpl() {
        connection = DatabaseConnection.getConnection();
    }

    // Function for adding new job listing

    @Override
    public void addJobListing(JobListingModal jobListing) throws DatabaseException {
        String sql = "INSERT INTO joblisting (title, description, requirements, posted_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jobListing.getTitle());
            stmt.setString(2, jobListing.getDescription());
            stmt.setString(3, jobListing.getRequirements());
            stmt.setString(4, jobListing.getPostedDate());
            stmt.setString(5, jobListing.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add job listing.");
        }

    }


    // Function to view all listed job

    @Override
    public List<JobListingModal> getAllJobListings() throws DatabaseException {
        List<JobListingModal> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM joblisting";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                JobListingModal jobListing = new JobListingModal(
                        rs.getInt("job_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("requirements"),
                        rs.getString("posted_date"),
                        rs.getString("status")
                );
                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to get all job listing.");
        }
        return jobListings;
    }




    // Function to Update already listed job
    @Override
    public void updateJobListing(JobListingModal jobListing) throws DatabaseException {
        String sql = "UPDATE joblisting SET title = ?, description = ?, requirements = ?, posted_date = ?, status = ? WHERE job_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jobListing.getTitle());
            stmt.setString(2, jobListing.getDescription());
            stmt.setString(3, jobListing.getRequirements());
            stmt.setString(4, jobListing.getPostedDate());
            stmt.setString(5, jobListing.getStatus());
            stmt.setInt(6, jobListing.getJobId());
            stmt.executeUpdate();
            System.out.println("Job Listing updated successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update job listing.");
        }

    }




    //Function to Delete existing job
    @Override
    public void deleteJobListing(int jobId) throws DatabaseException {
        String sql = "DELETE FROM joblisting WHERE job_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, jobId);
            stmt.executeUpdate();
            System.out.println("Job Listing deleted successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete job listing.");
        }
    }
}
