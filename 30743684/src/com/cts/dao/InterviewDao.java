package com.cts.dao;

import com.cts.exception.DatabaseException;
import com.cts.modal.InterviewModal;

import java.util.List;

public interface InterviewDao {

    void addInterview(InterviewModal interview) throws DatabaseException;
    List<InterviewModal> getAllInterviews() throws DatabaseException;
    void updateInterview(InterviewModal interview) throws DatabaseException;
    void deleteInterview(int interviewId) throws DatabaseException;
}
