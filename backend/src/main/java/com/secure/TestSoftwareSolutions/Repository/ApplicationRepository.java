package com.secure.TestSoftwareSolutions.Repository;
import com.secure.TestSoftwareSolutions.Models.Application;
import com.secure.TestSoftwareSolutions.Models.Candidate;
import org.springframework.data.repository.ListCrudRepository;
public interface ApplicationRepository extends ListCrudRepository<Application, Integer>  {
    //Application findByEmail(String email);

    Application findFirstBycandidateId(Long candidateId);
}
