package com.secure.secureapp.Controller;

import com.secure.secureapp.Models.Candidate;
import com.secure.secureapp.dto.ApplyDTO;
import com.secure.secureapp.dto.ApplicationDTO;
import com.secure.secureapp.services.jwt.UserDetailsServiceImpl;
import com.secure.secureapp.services.application.OrderService;
import com.secure.secureapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplyController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/apply")
    public ResponseEntity<?> createOrder(@RequestBody ApplyDTO createOrderDTO) {
        Candidate user = userDetailsService.findByEmail(createOrderDTO.getEmail());

        if (user == null) {
            // User does not exist, return an error response
            return new ResponseEntity<>("User not found with the provided email.", HttpStatus.BAD_REQUEST);
        }

        String authToken = jwtUtil.generateToken(user.getEmail());

        ApplicationDTO orderDTO = orderService.createApplication(createOrderDTO);
        if (orderDTO == null) {
            return new ResponseEntity<>("Order not created, come again later!", HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("order", orderDTO);
        response.put("authToken", authToken);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
