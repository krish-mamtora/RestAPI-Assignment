package com.example.RestAPI2.service;

import com.example.RestAPI2.dto.EmployeeDTO;
import com.example.RestAPI2.model.Employee;
import com.example.RestAPI2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class EmployeeService  {

    @Autowired
    private  EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setName((dto.getName()));
        employee.setDepartment(dto.getDepartment());
        employee.setEmail(dto.getEmail());

        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO>dtoList = new ArrayList<>();
        for(Employee book : employees){
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(book.getId());
            dto.setDepartment(book.getDepartment());
            dto.setEmail(book.getEmail());
            dto.setName(book.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        Employee book = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(book.getId());
        dto.setDepartment(book.getDepartment());
        dto.setEmail(book.getEmail());
        dto.setName(book.getName());
        return dto;
    }

//    public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO) {
//        EmployeeDTO existing = getEmployeeById(id);
//        existing.setName(employeeDTO.getName());
//        existing.setDepartment(employeeDTO.getDepartment());
//        return employeeRepository.save(existing);
//    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee uploadProfilePicture(Integer id, String name, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        if (!file.getContentType().startsWith("image/")) {
            throw new IllegalArgumentException("Only image files are allowed");
        }

        Employee emp = (id != null) ?
                employeeRepository.findById(id).orElse(new Employee()) :
                new Employee();


        emp.setName(name);
        emp.setProfilePicture(file.getBytes());
        emp.setPictureType(file.getContentType());

        return emp;
    }

    public Optional<Employee> getProfilePicture(Integer id) {
        return employeeRepository.findById(id);
    }
}
