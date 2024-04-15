package com.secure.TestSoftwareSolutions.Repository;
import com.secure.TestSoftwareSolutions.Models.Application;
import org.springframework.data.repository.ListCrudRepository;
public interface ApplicationRepository extends ListCrudRepository<Application, Integer>  {
    //Application findByEmail(String email);
}
