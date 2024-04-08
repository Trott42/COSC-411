package com.secure.secureapp.services.application;

import com.secure.secureapp.Models.Application;
import com.secure.secureapp.Models.Employer;
import com.secure.secureapp.Repository.ApplicationRepository;
import com.secure.secureapp.dto.ApplyDTO;
import com.secure.secureapp.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public ApplicationDTO createApplication(ApplyDTO applyDTO)
    {
        Application application=new Application();
        application.setCandidateId(applyDTO.getCandidateId());
        application.setSubmittedDate(LocalDate.now());
        application.setUpdateDate(LocalDate.now());
        application.setEmployeeId(applyDTO.getEmployeeId());
        application.setApplicationStatus(applyDTO.getApplicationStatus());
        Application createApplication= applicationRepository.save(application);
        ApplicationDTO applicationDTO=new ApplicationDTO();
        applicationDTO.setApplicationId(createApplication.getEmployeeId());
        applicationDTO.setOrderName(createApplication.getOrderName());
        applicationDTO.setOrderDate(createApplication.getOrderDate());
        applicationDTO.setEmail(createApplication.getEmail());
        applicationDTO.setPrice(createApplication.getPrice());
        applicationDTO.setOrderNumber(createApplication.getOrderNumber());
        return applicationDTO;
    }

    @Override
    public ApplicationDTO getOrderDetails(String email, Long orderNumber) {
        if (email == null || orderNumber == null) {
            return null;
        }

        // Retrieve the order from the repository
        Employer orderModel = applicationRepository.findFirstByEmailAndOrderNumber(email, orderNumber);

        if (orderModel == null) {
            return null; // Order not found
        }

        // Convert the OrderModel to OrderDTO
        ApplicationDTO orderDTO = new ApplicationDTO();
        orderDTO.setId(orderModel.getEmployeeId());
        orderDTO.setOrderName(orderModel.getOrderName());
        orderDTO.setOrderDate(orderModel.getOrderDate());
        orderDTO.setEmail(orderModel.getEmail());
        orderDTO.setPrice(orderModel.getPrice());
        orderDTO.setOrderNumber(orderModel.getOrderNumber());

        return orderDTO;
    }

}
