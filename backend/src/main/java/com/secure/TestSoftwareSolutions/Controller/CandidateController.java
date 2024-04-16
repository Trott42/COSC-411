package com.secure.TestSoftwareSolutions.Controller;

import com.secure.TestSoftwareSolutions.Repository.CandidateRepository;
import com.secure.TestSoftwareSolutions.dto.AuthenticationDTO;
import com.secure.TestSoftwareSolutions.dto.AuthenticationResponse;
import com.secure.TestSoftwareSolutions.dto.CandidateDTO;
import com.secure.TestSoftwareSolutions.services.application.CandidateService;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.ICandidateService;
import com.secure.TestSoftwareSolutions.services.jwt.CustomUserDetails;
import com.secure.TestSoftwareSolutions.services.jwt.UserDetailsServiceImpl;
import com.secure.TestSoftwareSolutions.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    @Autowired
    private ICandidateService CandidateService;
    private CandidateRepository candidateRepository;
    @PostMapping("/candidate")
    public void addCandidate(@RequestBody CandidateDTO candidateDTO) {
        CandidateService.createCandidate(candidateDTO);
    }

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody CandidateDTO candidateDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(candidateDTO.getEmail(), candidateDTO.getHashedPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }
        boolean employee=false;
        final UserDetails userDetails = userDetailsService.loadUserByUsername(candidateDTO.getEmail());
        Long candidateId = ((CustomUserDetails) userDetails).getCandidateId();

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt,candidateId);

    }

    @GetMapping("/candidate")
    public ResponseEntity<CandidateDTO> getCandidatebyId(
            @RequestParam Long candidateId
    ) {
        // Call the service to get the order details
        CandidateDTO candidateDTO = CandidateService.getCandidatebyId(candidateId);

        return new ResponseEntity<>(candidateDTO, HttpStatus.OK);
    }
}
