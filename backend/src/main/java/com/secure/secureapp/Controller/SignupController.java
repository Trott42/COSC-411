package com.secure.secureapp.Controller;

import com.secure.secureapp.Repository.CandidateRepository;
import com.secure.secureapp.dto.CandidateDTO;
import com.secure.secureapp.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;
    private CandidateRepository userRepository;
    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody CandidateSignupDTO signupDTO) {
       CandidateDTO createdUser = authService.createUser(signupDTO);


       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
