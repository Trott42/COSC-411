package com.secure.TestSoftwareSolutions.services.application.Interfaces;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;
import com.secure.TestSoftwareSolutions.dto.CandidateDTO;

import java.util.List;

public interface IApplicationService {
    void createApplication(ApplicationDTO createOrderDTO);

    List<ApplicationDTO> getApplication();

    ApplicationDTO getCandidateById(Long candidateId);

    ApplicationDTO decision(Long candidateId,String applicationStatus,Long employeeId);
}
