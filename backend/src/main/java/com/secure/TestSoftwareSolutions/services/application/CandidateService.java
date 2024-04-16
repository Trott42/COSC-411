package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Candidate;
import com.secure.TestSoftwareSolutions.Repository.CandidateRepository;
import com.secure.TestSoftwareSolutions.dto.CandidateDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
        candidate.setCreateDate(LocalDate.now());
        candidate.setHashedPassword(new BCryptPasswordEncoder().encode(candidateDTO.getHashedPassword()));
        candidateRepository.save(candidate);
    }

    @Override
    public CandidateDTO getCandidatebyId(Long candidateId) {
        Candidate candidate= candidateRepository.findFirstBycandidateId(candidateId);
        CandidateDTO candidateDTO=new CandidateDTO();
        candidateDTO.setFName(candidate.getFName());
        candidateDTO.setLName(candidate.getLName());
        candidateDTO.setEmail(candidate.getEmail());
        candidateDTO.setPhone(candidate.getPhone());
        candidateDTO.setAddress(candidate.getAddress());
        candidateDTO.setCity(candidate.getCity());
        candidateDTO.setZipCode(candidate.getZipcode());
        return candidateDTO;

    }




}
