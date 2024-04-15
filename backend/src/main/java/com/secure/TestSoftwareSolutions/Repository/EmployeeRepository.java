package com.secure.TestSoftwareSolutions.Repository;

import com.secure.TestSoftwareSolutions.Models.Employer;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employer, Integer> {
    Employer findFirstByEmail(String email);
}
