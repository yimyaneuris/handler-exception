package com.example.handlerexception.repository;

import com.example.handlerexception.entity.Address;
import com.example.handlerexception.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Address getByAddress(Long employeeId);
}
