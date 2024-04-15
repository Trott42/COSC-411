package com.secure.TestSoftwareSolutions.Repository;

import com.secure.TestSoftwareSolutions.Models.Candidate;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends ListCrudRepository<Candidate, Integer> {
    Candidate findFirstByEmail(String email);

}
