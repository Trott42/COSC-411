package com.secure.secureapp.Models;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Data
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String fName;
    private String lName;
    @Column(unique = true)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @Column(unique = true)
    private String phone;
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
    public String getPhone(){return phone;}
}
