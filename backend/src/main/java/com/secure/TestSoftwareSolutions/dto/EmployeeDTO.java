package com.secure.TestSoftwareSolutions.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long employeeId;

    private String fName;
    private String lName;
    private String email;
    private String jobTitle;

    private LocalDate createDate;
    private String hashedPassword;

    public String getFName() {return fName;}
    public String getLName() {return lName;}
    public LocalDate getCreateDate(){return createDate;}
    public String getEmail() {
        return email;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }


    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
