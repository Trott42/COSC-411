package com.secure.TestSoftwareSolutions.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class ApplicationDTO {
    private Long ApplicationId;
    private Long  candidateId;
    private long resumeId;
    private Long employeeId;

    private Long jobId;

    private LocalDate submittedDate;

    private LocalDate updateDate;
    private String applicationStatus;

    public Long getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(Long applicationId) {
        ApplicationId = applicationId;
    }

    public Long  getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long  candidateId) {
        this.candidateId = candidateId;
    }

    public long getResumeId() {
        return resumeId;
    }

    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
