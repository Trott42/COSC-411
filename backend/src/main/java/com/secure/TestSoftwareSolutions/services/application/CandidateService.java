package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Candidate;
import com.secure.TestSoftwareSolutions.Repository.CandidateRepository;
import com.secure.TestSoftwareSolutions.dto.CandidateDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Override
    public void createCandidate(CandidateDTO candidateDTO)
    {
        Candidate candidate=new Candidate();
        candidate.setFName(candidateDTO.getFName());
        candidate.setLName(candidateDTO.getLName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setPhone(candidateDTO.getPhone());
        candidate.setAddress(candidateDTO.getAddress());
        candidate.setCity(candidateDTO.getCity());
        candidate.setZipCode(candidateDTO.getZipcode());
        candidate.setCreateDate(candidateDTO.getCreateDate());
        candidate.setHashedPassword(new BCryptPasswordEncoder().encode(candidateDTO.getHashedPassword()));
        candidateRepository.save(candidate);
    }



}
