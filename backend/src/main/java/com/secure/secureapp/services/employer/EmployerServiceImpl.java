package com.secure.secureapp.services.employer;

import com.secure.secureapp.Models.Employer;
import com.secure.secureapp.dto.CandidateDTO;

import java.time.LocalDate;

public class EmployerServiceImpl {

    Employer employer = new Employer();
        employer.setFName(signupDTO.getFName());
        employer.setLName(signupDTO.getLName());
        employer.setEmail(signupDTO.getEmail());
        employer.setHashedPassword(new BCryptPasswordEncoder().encode(signupDTO.getHashedPassword()));
        employer.setPhone(signupDTO.getPhone());
        employer.setCreateDate(LocalDate.now());
        employer.setAddress(signupDTO.getAddress());
        employer.setCity(signupDTO.getCity());
        employer.setZipCode(signupDTO.getZipCode());
    Employer createdEmployer = userRepository.save(employer);
    CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidateId(createdEmployer.getCandidateId());
        candidateDTO.setEmail(createdEmployer.getEmail());
        candidateDTO.setFName(createdEmployer.getFName());
        candidateDTO.setLName(createdEmployer.getLName());
        candidateDTO.setPhone(createdEmployer.getPhone());
        candidateDTO.setAddress(createdEmployer.getAddress());
        candidateDTO.setCity(createdEmployer.getCity());
        candidateDTO.setZipCode(createdEmployer.getZipcode());
        candidateDTO.setCreateDate(createdEmployer.getCreateDate());

        return candidateDTO;
}
