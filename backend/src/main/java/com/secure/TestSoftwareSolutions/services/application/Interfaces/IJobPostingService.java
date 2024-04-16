package com.secure.TestSoftwareSolutions.services.application.Interfaces;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.dto.JobDTO;

import java.util.List;

public interface IJobPostingService {
     void createJob(JobDTO jobDTO);
     List<JobDTO> getJob();
     JobDTO getJobById(Long jobId);
}
