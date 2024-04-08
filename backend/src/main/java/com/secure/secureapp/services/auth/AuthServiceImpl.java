package com.secure.secureapp.services.auth;

import com.secure.secureapp.dto.CandidateDTO;
import com.secure.secureapp.Models.Candidate;
import com.secure.secureapp.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CandidateRepository userRepository;

    @Override
    public CandidateDTO createUser(CandidateSignupDTO signupDTO) {
        Candidate user = new Candidate();
        user.setFName(signupDTO.getFName());
        user.setLName(signupDTO.getLName());
        user.setEmail(signupDTO.getEmail());
        user.setHashedPassword(new BCryptPasswordEncoder().encode(signupDTO.getHashedPassword()));
        user.setPhone(signupDTO.getPhone());
        user.setCreateDate(LocalDate.now());
        user.setAddress(signupDTO.getAddress());
        user.setCity(signupDTO.getCity());
        user.setZipCode(signupDTO.getZipCode());
        Candidate createdUser = userRepository.save(user);
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidateId(createdUser.getCandidateId());
        candidateDTO.setEmail(createdUser.getEmail());
        candidateDTO.setFName(createdUser.getFName());
        candidateDTO.setLName(createdUser.getLName());
        candidateDTO.setPhone(createdUser.getPhone());
        candidateDTO.setAddress(createdUser.getAddress());
        candidateDTO.setCity(createdUser.getCity());
        candidateDTO.setZipCode(createdUser.getZipcode());
        candidateDTO.setCreateDate(createdUser.getCreateDate());

        return candidateDTO;
    }
}
