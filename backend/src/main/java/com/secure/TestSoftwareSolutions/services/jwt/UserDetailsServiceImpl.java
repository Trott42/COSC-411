package com.secure.TestSoftwareSolutions.services.jwt;

import com.secure.TestSoftwareSolutions.Models.Candidate;
import com.secure.TestSoftwareSolutions.Models.Employer;
import com.secure.TestSoftwareSolutions.Repository.EmployeeRepository;
import com.secure.TestSoftwareSolutions.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CandidateRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Write Logic to get the user from the DB
        String employeeDomain = "@testsoftwaresolutions.com";

        if(email.endsWith(employeeDomain)){
            Employer employeeUser= employeeRepository.findFirstByEmail(email);
            if(employeeUser == null){
                throw new UsernameNotFoundException("User not found",null);
            }
            return new org.springframework.security.core.userdetails.User(employeeUser.getEmail(), employeeUser.getHashedPassword(), new ArrayList<>());
        }
        else{
            Candidate candidateUser = userRepository.findFirstByEmail(email);
            if(candidateUser == null){
                throw new UsernameNotFoundException("User not found",null);
            }
            return new org.springframework.security.core.userdetails.User(candidateUser.getEmail(), candidateUser.getHashedPassword(), new ArrayList<>());
        }

    }

}
