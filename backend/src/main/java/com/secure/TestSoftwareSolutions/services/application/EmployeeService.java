package com.secure.TestSoftwareSolutions.services.application;

import com.secure.TestSoftwareSolutions.Models.Employer;
import com.secure.TestSoftwareSolutions.Repository.EmployeeRepository;
import com.secure.TestSoftwareSolutions.dto.EmployeeDTO;
import com.secure.TestSoftwareSolutions.services.application.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employer employer =new Employer();
        employer.setfName(employeeDTO.getFName());
        employer.setlName(employeeDTO.getLName());
        employer.setEmail(employeeDTO.getEmail());
        employer.setJobTitle(employeeDTO.getJobTitle());
        employer.setCreateDate(LocalDate.now());
        employer.setHashedPassword(new BCryptPasswordEncoder().encode(employeeDTO.getHashedPassword()));
        employeeRepository.save(employer);
    }
}
