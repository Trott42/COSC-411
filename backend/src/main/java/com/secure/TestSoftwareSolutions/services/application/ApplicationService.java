package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Application;
import com.secure.TestSoftwareSolutions.Repository.ApplicationRepository;
import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public void createApplication(ApplicationDTO applyDTO)
    {
        Application application=new Application();
        application.setCandidateId(applyDTO.getCandidateId());
        application.setSubmittedDate(LocalDate.now());
        application.setUpdateDate(LocalDate.now());
        application.setEmployeeId(applyDTO.getEmployeeId());
        application.setApplicationStatus(applyDTO.getApplicationStatus());
        applicationRepository.save(application);
    }

    @Override
    public ApplicationDTO getApplicaition(String email) {
        return null;
    }


}
