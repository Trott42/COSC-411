package com.secure.TestSoftwareSolutions.Controller;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.dto.JobDTO;
import com.secure.TestSoftwareSolutions.services.jwt.UserDetailsServiceImpl;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IApplicationService;
import com.secure.TestSoftwareSolutions.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public void createApplication(@RequestBody ApplicationDTO apply) {

        applicationService.createApplication(apply);
    }

    @GetMapping("/apply")
    public List<ApplicationDTO> getAllJobs() {
        return applicationService.getApplication();
    }
}
