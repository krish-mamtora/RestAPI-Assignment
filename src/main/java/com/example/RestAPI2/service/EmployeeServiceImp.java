package com.example.RestAPI2.service;

import com.example.RestAPI2.dto.EmployeeDTO;
import com.example.RestAPI2.dto.EmployeeResponseDTO;
import com.example.RestAPI2.dto.EmployessRequestDTO;
import com.example.RestAPI2.model.Employee;
import com.example.RestAPI2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@EnableCaching
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private  EmployeeRepository employeeRepository;

    private Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
    }
    private EmployeeResponseDTO map(Employee e){
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(e.getId());
        dto.setname(e.getName());
        dto.setEmail(e.getEmail());
        dto.setCreatdAt(e.getCreatedAt());
        return dto;
    }

    @Override
    public EmployeeResponseDTO create(EmployessRequestDTO dto) {
        Employee employee = new Employee();
        employee.setName((dto.getName()));
        employee.setDepartment(dto.getDepartment());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
       return map(employeeRepository.save(employee));
    }
    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::map).toList();
    }
    @Override
    public EmployeeResponseDTO getEmployeeById(Integer id) {
        return map(getEmployee(id));
    }
    @Override
    public EmployeeResponseDTO updateEmployee(Integer id, EmployessRequestDTO dto) {
        Employee e = getEmployee(id);
        e.setName(dto.getName());
        e.setDepartment(dto.getDepartment());
        return map(employeeRepository.save(e));
    }
    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @CacheEvict(value = "profileImage" , key="#id")
    public void uploadProfileImage (Integer id , MultipartFile file){
        Employee e = getEmployee(id);
        try{
            e.setProfileImage(file.getBytes());
            e.setProfileImageType(file.getContentType());
            employeeRepository.save(e);
        }catch(IOException ex){
            throw new RuntimeException("Image upload failed");
        }
    }

    @Override
    @Cacheable(value = "profileImage" , key="#id")
    public byte[] getProfileImage(Integer id){
        Employee e = getEmployee(id);
        return e.getProfileImage();
    }

}
