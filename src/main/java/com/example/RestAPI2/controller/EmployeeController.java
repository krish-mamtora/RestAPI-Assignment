package com.example.RestAPI2.controller;

import com.example.RestAPI2.dto.EmployeeDTO;
import com.example.RestAPI2.model.Employee;
import com.example.RestAPI2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

//    @PutMapping("/{id}")
//    public EmployeeDTO updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
//        return employeeService.updateEmployee(id, employeeDTO);
//    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfilePicture(
            @RequestParam(required = false) Integer id,
            @RequestParam String name,
            @RequestParam MultipartFile file) {
        try {
            Employee saved = employeeService.uploadProfilePicture(id, name, file);
            return ResponseEntity.ok("Profile picture uploaded successfully. Employee ID: " + saved.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error processing file");
        }
    }

    @GetMapping("/{id}/picture")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Integer id) {
        return employeeService.getProfilePicture(id)
                .map(profile -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"profile_" + id + "\"")
                        .contentType(MediaType.parseMediaType(profile.getPictureType()))
                        .body(profile.getProfilePicture()))
                .orElse(ResponseEntity.notFound().build());
    }
}
