package com.secure.TestSoftwareSolutions.services.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private Long candidateId;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long candidateId) {
        super(username, password, authorities);
        this.candidateId = candidateId;
    }

    public Long getCandidateId() {
        return candidateId;
    }
}
