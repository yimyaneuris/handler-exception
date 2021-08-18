package com.example.handlerexception.controller;

import com.example.handlerexception.entity.Address;
import com.example.handlerexception.entity.Employee;
import com.example.handlerexception.exception.BusinessException;
import com.example.handlerexception.exception.InvalidInputException;
import com.example.handlerexception.exception.UnauthorizedException;
import com.example.handlerexception.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository employeeRepository;

    // Bad Practice, is better using low coupling, using service for other
    Employee employee = null;
    Address address = null;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<String> Get() {
        return ResponseEntity.ok("This  is a little method");
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getAllEmployee(@PathVariable Long id) {
        ResponseEntity<?> response = null;

        if(null == id || id.equals(0L)) {
                throw new InvalidInputException("Employee id is not valid");
            }

            employee = employeeRepository.getById(id);
            response = new ResponseEntity<>(employee, HttpStatus.OK);

        return response;
    }

    @GetMapping(value = "/address/{employeeId}", produces = "application/json")
    public ResponseEntity<?> getAddress(@PathVariable Long employeeId, @RequestHeader Long user_id) {
        ResponseEntity<Address> response = null;

            if(null == employeeId) {
                throw new InvalidInputException("Employee id is not valid");
            }

            if(null == user_id || user_id.equals(0L)) {
                throw new UnauthorizedException("Unauthorized user.");
            }

            address = employeeRepository.getByAddress(employeeId);
            response = new ResponseEntity<>(address, HttpStatus.OK);

        return response;
    }
}
