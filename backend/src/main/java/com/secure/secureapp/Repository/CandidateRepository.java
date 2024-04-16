package com.secure.secureapp.Repository;

import com.secure.secureapp.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findFirstByEmail(String email);

}