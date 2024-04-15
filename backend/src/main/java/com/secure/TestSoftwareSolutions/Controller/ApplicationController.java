package com.secure.TestSoftwareSolutions.Controller;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.services.jwt.UserDetailsServiceImpl;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IApplicationService;
import com.secure.TestSoftwareSolutions.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/apply")
    public void createOrder(@RequestBody ApplicationDTO apply) {

        applicationService.createApplication(apply);

        Map<String, Object> response = new HashMap<>();

    }
}
