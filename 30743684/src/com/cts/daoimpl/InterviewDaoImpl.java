package com.cts.daoimpl;

import com.cts.dao.InterviewDao;
import com.cts.exception.DatabaseException;
import com.cts.modal.InterviewModal;
import com.cts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InterviewDaoImpl implements InterviewDao {

    Connection connection;

    public InterviewDaoImpl() {
        connection = DatabaseConnection.getConnection();
    }
    @Override
    public void addInterview(InterviewModal interview) throws DatabaseException {
        String sql = "INSERT INTO Interview (job_id, applicant_id, interview_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, interview.getJobId());
            stmt.setInt(2, interview.getApplicantId());
            stmt.setString(3, interview.getInterviewDate());
            stmt.setString(4, interview.getStatus());
            stmt.executeUpdate();
            System.out.println("Interview added successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add interview.");
        }
    }

    @Override
    public List<InterviewModal> getAllInterviews() throws DatabaseException {
        List<InterviewModal> interviews = new ArrayList<>();
        String sql = "SELECT * FROM Interview";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                InterviewModal interview = new InterviewModal(
                        rs.getInt("interview_id"),
                        rs.getInt("job_id"),
                        rs.getInt("applicant_id"),
                        rs.getString("interview_date"),
                        rs.getString("status")
                );
                interviews.add(interview);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to get all interviews.");
        }
        return interviews;
    }

    @Override
    public void updateInterview(InterviewModal interview) throws DatabaseException {
        String sql = "UPDATE Interview SET job_id = ?, applicant_id = ?, interview_date = ?, status = ? WHERE interview_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, interview.getJobId());
            stmt.setInt(2, interview.getApplicantId());
            stmt.setString(3, interview.getInterviewDate());
            stmt.setString(4, interview.getStatus());
            stmt.setInt(5, interview.getInterviewId());
            stmt.executeUpdate();
            System.out.println("Interview details updated successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update interview.");
        }
    }

    @Override
    public void deleteInterview(int interviewId) throws DatabaseException {
        String sql = "DELETE FROM Interview WHERE interview_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, interviewId);
            stmt.executeUpdate();
            System.out.println("Interview deleted successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete job listing.");
        }
    }
}
