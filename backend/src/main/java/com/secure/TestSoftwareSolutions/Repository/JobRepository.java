package com.secure.TestSoftwareSolutions.Repository;

import com.secure.TestSoftwareSolutions.Models.Application;
import com.secure.TestSoftwareSolutions.Models.Job;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends ListCrudRepository<Job, Integer> {
    Job findFirstByjobId(Long jobId);
}
