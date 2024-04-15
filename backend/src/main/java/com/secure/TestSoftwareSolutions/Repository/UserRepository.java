package com.secure.TestSoftwareSolutions.Repository;

import com.secure.TestSoftwareSolutions.Models.Candidate;
import com.secure.TestSoftwareSolutions.Models.Employer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<Candidate, Integer> {
    Candidate findFirstByEmail(String email);

}
