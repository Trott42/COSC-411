package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Job;
import com.secure.TestSoftwareSolutions.Repository.JobRepository;
import com.secure.TestSoftwareSolutions.dto.JobDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostingService implements IJobPostingService {

    @Autowired
    JobRepository jobRepository;
    @Override
    public void createJob(JobDTO jobDTO) {
        Job jobPosting = new Job();
        jobPosting.setJobTitle(jobDTO.getJobTitle());
        jobPosting.setJobDescription(jobDTO.getJobDescription());
        jobPosting.setJobRequirements(jobDTO.getJobRequirements());
        jobPosting.setLocation(jobDTO.getLocation());
        jobPosting.setCreateDate(LocalDate.now());
        jobRepository.save(jobPosting);
    }

    @Override
    public List<JobDTO> getJob(){
        return jobRepository.findAll()
                .stream()
                .map(client -> map(client))
                .toList();
    }
    public JobDTO map(Job jobPosting) {
        JobDTO jobDTO=new JobDTO();
        jobDTO.setJobId(jobPosting.getJobId());
        jobDTO.setJobTitle(jobPosting.getJobTitle());
        jobDTO.setJobDescription(jobPosting.getJobDescription());
        jobDTO.setJobRequirements(jobPosting.getJobRequirements());
        jobDTO.setLocation(jobPosting.getLocation());
        jobDTO.setCreateDate(jobPosting.getCreateDate());
        return jobDTO;
    }
}
