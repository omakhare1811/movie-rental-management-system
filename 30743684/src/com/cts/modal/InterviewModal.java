package com.cts.modal;

public class InterviewModal {
    private int interviewId;
    private int jobId;
    private int applicantId;
    private String interviewDate;
    private String status;



    // this constructor is for updating the existing interview
    public InterviewModal(int interviewId, int jobId, int applicantId, String interviewDate, String status) {
        this.interviewId = interviewId;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.interviewDate = interviewDate;
        this.status = status;
    }

    // this constructor is for adding new interview
    public InterviewModal( int jobId, int applicantId, String interviewDate, String status) {
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.interviewDate = interviewDate;
        this.status = status;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
