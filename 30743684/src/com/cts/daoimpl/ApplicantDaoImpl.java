package com.cts.daoimpl;

import com.cts.dao.ApplicantDao;
import com.cts.exception.DatabaseException;
import com.cts.modal.ApplicantModal;
import com.cts.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDaoImpl implements ApplicantDao {
    Connection connection;

    public ApplicantDaoImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addApplicant(ApplicantModal applicant) throws DatabaseException {
        String sql = "INSERT INTO Applicant (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, applicant.getName());
            stmt.setString(2, applicant.getEmail());
            stmt.setString(3, applicant.getPhoneNumber());
            stmt.setString(4, applicant.getAddress());
            stmt.executeUpdate();
            System.out.println("Applicant added successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add applicant.");

        }
    }

    @Override
    public List<ApplicantModal> getAllApplicants() throws DatabaseException {
        List<ApplicantModal> applicants = new ArrayList<>();
        String sql = "SELECT * FROM Applicant";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ApplicantModal applicant = new ApplicantModal(
                        rs.getInt("applicant_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address")
                );
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to get all applicants.");
        }
        return applicants;
    }

    @Override
    public void updateApplicant(ApplicantModal applicant) throws DatabaseException {
        String sql = "UPDATE Applicant SET name = ?, email = ?, phone_number = ?, address = ? WHERE applicant_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, applicant.getName());
            stmt.setString(2, applicant.getEmail());
            stmt.setString(3, applicant.getPhoneNumber());
            stmt.setString(4, applicant.getAddress());
            stmt.setInt(5, applicant.getApplicantId());
            stmt.executeUpdate();
            System.out.println("Applicant details updated successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update applicant.");
        }
    }

    @Override
    public void deleteApplicant(int applicantId) throws DatabaseException {
        String sql = "DELETE FROM Applicant WHERE applicant_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, applicantId);
            stmt.executeUpdate();
            System.out.println("Applicant deleted successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete applicant.");
        }
    }
}
