package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Application;
import com.secure.TestSoftwareSolutions.Models.Candidate;
import com.secure.TestSoftwareSolutions.Models.Job;
import com.secure.TestSoftwareSolutions.Repository.ApplicationRepository;
import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.dto.JobDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public void createApplication(ApplicationDTO applyDTO)
    {
        Application application=new Application();
        application.setCandidateId(applyDTO.getCandidateId());
        application.setResumeId(applyDTO.getResumeId());
        application.setSubmittedDate(LocalDate.now());
        application.setUpdateDate(applyDTO.getUpdateDate());
        application.setEmployeeId(applyDTO.getEmployeeId());
        application.setApplicationStatus(applyDTO.getApplicationStatus());
        application.setJobId(applyDTO.getJobId());
        applicationRepository.save(application);
    }

    @Override
    public List<ApplicationDTO> getApplication(){
        return applicationRepository.findAll()
                .stream()
                .map(client -> map(client))
                .toList();
    }

    @Override
    public ApplicationDTO getCandidateById(Long candidateId) {
       Application application= applicationRepository.findFirstBycandidateId(candidateId);
        ApplicationDTO applicationDTO=new ApplicationDTO();
        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setCandidateId(application.getCandidateId());
        applicationDTO.setEmployeeId(application.getEmployeeId());
        applicationDTO.setResumeId(application.getResumeId());
        applicationDTO.setSubmittedDate(application.getSubmittedDate());
        applicationDTO.setApplicationStatus(application.getApplicationStatus());
        applicationDTO.setUpdateDate(application.getUpdateDate());
        applicationDTO.setJobId(application.getJobId());
        return applicationDTO;
    }

    public ApplicationDTO map(Application application) {
        ApplicationDTO applicationDTO=new ApplicationDTO();
        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setCandidateId(application.getCandidateId());
        applicationDTO.setEmployeeId(application.getEmployeeId());
        applicationDTO.setResumeId(application.getResumeId());
        applicationDTO.setSubmittedDate(application.getSubmittedDate());
        applicationDTO.setApplicationStatus(application.getApplicationStatus());
        applicationDTO.setUpdateDate(application.getUpdateDate());
        applicationDTO.setJobId(application.getJobId());
        return applicationDTO;
    }


}
