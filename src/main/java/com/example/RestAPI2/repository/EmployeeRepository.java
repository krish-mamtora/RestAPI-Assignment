package com.example.RestAPI2.repository;

import com.example.RestAPI2.dto.EmployeeDTO;
import com.example.RestAPI2.model.Employee;
import org.hibernate.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);
}
