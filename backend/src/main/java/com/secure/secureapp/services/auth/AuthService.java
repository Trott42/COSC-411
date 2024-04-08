package com.secure.secureapp.services.auth;

import com.secure.secureapp.dto.CandidateDTO;

public interface AuthService {
    CandidateDTO createUser(CandidateSignupDTO signupDTO);
}
