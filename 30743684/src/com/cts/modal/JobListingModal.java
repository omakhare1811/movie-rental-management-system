package com.cts.modal;

public class JobListingModal {

    private int jobId;
    private String title;
    private String description;
    private String requirements;
    private String postedDate;
    private String status;


    // this constructor is for adding new job
    public JobListingModal(String title, String description, String requirements, String postedDate, String status) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.postedDate = postedDate;
        this.status = status;
    }


    // this constructor is for updating the existing job
    public JobListingModal(int jobId, String title, String description, String requirements, String postedDate, String status) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.postedDate = postedDate;
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
