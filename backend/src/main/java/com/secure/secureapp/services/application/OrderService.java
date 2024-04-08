package com.secure.secureapp.services.application;

import com.secure.secureapp.dto.ApplyDTO;
import com.secure.secureapp.dto.ApplicationDTO;

public interface OrderService {
    ApplicationDTO createApplication(ApplyDTO createOrderDTO);

    ApplicationDTO getOrderDetails(String email, Long orderNumber);
}
