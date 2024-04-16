package com.secure.TestSoftwareSolutions.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CandidateDTO {

    private Long candidateId;

    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String hashedPassword;
    private LocalDate createDate;
    private String address;
    private String city;
    private int zipCode;
    public String getFName() {return fName;}
    public String getLName() {return lName;}
    public LocalDate getCreateDate(){return createDate;}
    public String getEmail() {
        return email;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public String getPhone(){return phone;}
    public String getAddress(){return address;}
    public String getCity(){return city;}
    public int getZipcode(){return zipCode;}

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setFName(String fName) {
        this.fName=fName;
    }
    public void setLName(String lName) {
        this.lName=lName;
    }

    public void setPhone(String phone){this.phone=phone;}
    public void setAddress(String address){this.address=address;}
    public void setCreateDate(LocalDate createDate){this.createDate=createDate;}
    public void setCity(String city){this.city=city;}
    public void setZipCode(int zipCode){this.zipCode=zipCode;}
    public Long getCandidateId() {return candidateId;}

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
