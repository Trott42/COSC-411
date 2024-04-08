package com.secure.secureapp.services.jwt;

import com.secure.secureapp.Models.Candidate;
import com.secure.secureapp.Repository.EmployeeRepository;
import com.secure.secureapp.Repository.CandidateRepository;
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
    private EmployeeRepository orderRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //Write Logic to get the user from the DB
        Candidate user = userRepository.findFirstByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getHashedPassword(), new ArrayList<>());
    }

    public Candidate findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
}
