package com.secure.TestSoftwareSolutions.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String hashedPassword;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    public long getCandidateId() {return candidateId;}
}
