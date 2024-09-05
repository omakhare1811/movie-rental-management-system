package com.cts.client;


import com.cts.daoimpl.ApplicantDaoImpl;
import com.cts.daoimpl.InterviewDaoImpl;
import com.cts.daoimpl.JobListingDaoImpl;
import com.cts.exception.DatabaseException;
import com.cts.modal.ApplicantModal;
import com.cts.modal.InterviewModal;
import com.cts.modal.JobListingModal;

import java.util.List;
import java.util.Scanner;

public class Main {
   private static Scanner scanner = new Scanner(System.in);

   // This Class will manage job listing operations
   private static JobListingDaoImpl jobListingDaoImpl = new JobListingDaoImpl();

   // This class will manage applicant listing operations
   private static ApplicantDaoImpl applicantDaoImpl = new ApplicantDaoImpl();

   // This class will manage interview listing operations
   private static InterviewDaoImpl interviewDaoImpl = new InterviewDaoImpl();


   // Program Execution will start from this method.
    public static void main(String[] args) throws DatabaseException {
        while (true) {
            System.out.println("\nJob Portal System");
            System.out.println("1. Manage Job Listings");
            System.out.println("2. Manage Applicants");
            System.out.println("3. Manage Interviews");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageJobListings();
                    break;
                case 2:
                    manageApplicants();
                    break;
                case 3:
                    manageInterviews();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // Menu for Job listing management
    private static void manageJobListings() throws DatabaseException {
        System.out.println("\n1. Add Job");
        System.out.println("2. View Job");
        System.out.println("3. Update Job");
        System.out.println("4. Delete Job");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter requirements: ");
                String requirements = scanner.nextLine();
                System.out.print("Enter posted date (YYYY-MM-DD): ");
                String postedDate = scanner.nextLine();
                System.out.print("Enter status (active/inactive): ");
                String status = scanner.nextLine();
                JobListingModal jobListing = new JobListingModal(title, description, requirements, postedDate, status);
                jobListingDaoImpl.addJobListing(jobListing);
                System.out.println("Job Listing added successfully.");
                break;
            case 2:
                List<JobListingModal> jobListings = jobListingDaoImpl.getAllJobListings();
                for (JobListingModal job : jobListings) {
                    System.out.println();
                    System.out.println("Job ID: " +job.getJobId());
                    System.out.println("Job Title: "+job.getTitle());
                    System.out.println("Job Description: "+job.getDescription());
                    System.out.println("Job Requirements: "+job.getRequirements());
                    System.out.println("Posted Date: "+job.getPostedDate());
                    System.out.println("Job Status: "+job.getStatus());
                    System.out.println("---------------------------------------");
                }
                break;
            case 3:
                System.out.print("Enter Job ID to update: ");
                int updateJobId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String updatedTitle = scanner.nextLine();
                System.out.print("Enter description: ");
                String updatedDescription = scanner.nextLine();
                System.out.print("Enter requirements: ");
                String updatedRequirements = scanner.nextLine();
                System.out.print("Enter posted date (YYYY-MM-DD): ");
                String updatedPostedDate = scanner.nextLine();
                System.out.print("Enter status (active/inactive): ");
                String updatedStatus = scanner.nextLine();
                JobListingModal jobToUpdate = new JobListingModal(updateJobId,updatedTitle,updatedDescription,updatedRequirements,updatedPostedDate,updatedStatus);
                jobListingDaoImpl.updateJobListing(jobToUpdate);
                break;
            case 4:
                scanner.nextLine();
                System.out.print("Enter Job ID to delete: ");
                int deleteJobId = scanner.nextInt();
                jobListingDaoImpl.deleteJobListing(deleteJobId);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");

        }
    }

    // Menu for Applicant management
    private static void manageApplicants() throws DatabaseException {
        System.out.println("\n1. Register Applicant");
        System.out.println("2. View Applicant");
        System.out.println("3. Update Applicant");
        System.out.println("4. Delete Applicant");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scanner.nextLine(); // Consume newline
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                ApplicantModal applicant = new ApplicantModal(name, email, phoneNumber, address);
                applicantDaoImpl.addApplicant(applicant);

                break;
            case 2:
                List<ApplicantModal> applicants = applicantDaoImpl.getAllApplicants();
                for (ApplicantModal app : applicants) {
                    System.out.println();
                    System.out.println("Applicant ID: " +app.getApplicantId());
                    System.out.println("Applicant Name: " +app.getName());
                    System.out.println("Applicant Email: " +app.getEmail());
                    System.out.println("Applicant Number: " +app.getPhoneNumber());
                    System.out.println("Applicant Address: " +app.getAddress());
                    System.out.println("---------------------------------------");
                }
                break;
            case 3:
                System.out.print("Enter Applicant ID to update: ");
                int applicantId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();
                ApplicantModal updatedApplicant = new ApplicantModal(applicantId,newName, newEmail, newPhoneNumber, newAddress);
                applicantDaoImpl.updateApplicant(updatedApplicant);
                break;
            case 4:
                System.out.print("Enter Applicant ID to delete: ");
                int deleteApplicantId = scanner.nextInt();
                applicantDaoImpl.deleteApplicant(deleteApplicantId);

                break;
            default:
                System.out.println("Invalid choice. Please try again.");

        }
    }


    // Menu for Interview management
    private static void manageInterviews() throws DatabaseException {
        System.out.println("\n1. Schedule Interview");
        System.out.println("2. View Interview");
        System.out.println("3. Update Interview");
        System.out.println("4. Cancel Interview");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Job ID: ");
                int jobId = scanner.nextInt();
                System.out.print("Enter Applicant ID: ");
                int applicantId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter interview date (YYYY-MM-DD): ");
                String interviewDate = scanner.nextLine();
                System.out.print("Enter status (scheduled/completed/cancelled): ");
                String status = scanner.nextLine();
                InterviewModal interview = new InterviewModal(jobId, applicantId, interviewDate, status);
                interviewDaoImpl.addInterview(interview);

                break;
            case 2:
                List<InterviewModal> interviews = interviewDaoImpl.getAllInterviews();
                for (InterviewModal interviewItem : interviews) {
                    System.out.println();
                    System.out.println("Interview ID: "+interviewItem.getInterviewId());
                    System.out.println("Applicant ID: "+interviewItem.getApplicantId());
                    System.out.println("Job ID: "+interviewItem.getJobId());
                    System.out.println("Interview Date: "+interviewItem.getInterviewDate());
                    System.out.println("Interview Status: "+interviewItem.getStatus());
                    System.out.println("---------------------------------------");
                }
                break;
            case 3:
                System.out.print("Enter Interview ID to update: ");
                int interviewId = scanner.nextInt();
                System.out.print("Enter new Job ID: ");
                int newJobId = scanner.nextInt();
                System.out.print("Enter new Applicant ID: ");
                int newApplicantId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new Interview Date (YYYY-MM-DD): ");
                String newInterviewDate = scanner.nextLine();
                System.out.print("Enter new status (scheduled/completed/cancelled): ");
                String newStatus = scanner.nextLine();
                InterviewModal interviewToUpadte = new InterviewModal(interviewId, newJobId, newApplicantId, newInterviewDate, newStatus);
                interviewDaoImpl.updateInterview(interviewToUpadte);
                break;
            case 4:
                System.out.print("Enter Interview ID to cancel: ");
                int deleteInterviewId = scanner.nextInt();
                interviewDaoImpl.deleteInterview(deleteInterviewId);

                break;
            default:
                System.out.println("Invalid choice. Please try again.");

        }
    }
}
