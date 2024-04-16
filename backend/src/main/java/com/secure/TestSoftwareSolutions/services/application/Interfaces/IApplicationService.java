package com.secure.TestSoftwareSolutions.services.application.Interfaces;

import com.secure.TestSoftwareSolutions.dto.ApplicationDTO;

import java.util.List;

public interface IApplicationService {
    void createApplication(ApplicationDTO createOrderDTO);

    List<ApplicationDTO> getApplication();
}
