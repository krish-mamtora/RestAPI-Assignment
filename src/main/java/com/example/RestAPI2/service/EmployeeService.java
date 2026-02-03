package com.example.RestAPI2.service;

import com.example.RestAPI2.dto.EmployeeResponseDTO;
import com.example.RestAPI2.dto.EmployessRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO create (EmployessRequestDTO dto);
    EmployeeResponseDTO getEmployeeById(Integer id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee(Integer id , EmployessRequestDTO dto);
    void deleteEmployee(Integer id);

    void uploadProfileImage(Integer id , MultipartFile file);
    byte[] getProfileImage(Integer id);
}
