package com.secure.TestSoftwareSolutions.services.application.Interfaces;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;

public interface IApplicationService {
    void createApplication(ApplicationDTO createOrderDTO);

    ApplicationDTO getApplicaition(String email);
}
