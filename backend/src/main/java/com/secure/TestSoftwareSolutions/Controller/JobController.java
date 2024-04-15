package com.secure.TestSoftwareSolutions.Controller;

import com.secure.TestSoftwareSolutions.Models.Job;
import com.secure.TestSoftwareSolutions.Repository.CandidateRepository;
import com.secure.TestSoftwareSolutions.Repository.JobRepository;
import com.secure.TestSoftwareSolutions.dto.CandidateDTO;
import com.secure.TestSoftwareSolutions.dto.JobDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.ICandidateService;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private IJobPostingService jobPostingService;
    @PostMapping("/job")
    public void addJob(@RequestBody JobDTO jobDTO) {
        jobPostingService.createJob(jobDTO);
    }

    @GetMapping("/job")
    public List<JobDTO> getAllJobs() {
       return jobPostingService.getJob();
    }
}
