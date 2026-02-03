package com.example.RestAPI2.controller;
import com.example.RestAPI2.dto.EmployeeResponseDTO;
import com.example.RestAPI2.dto.EmployessRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import com.example.RestAPI2.dto.EmployeeDTO;
import com.example.RestAPI2.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeServiceImp employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployessRequestDTO employeeDTO) {
       return ResponseEntity.ok(employeeService.create(employeeDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Integer id, @RequestBody EmployessRequestDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<String> upload(
            @PathVariable Integer id , @RequestParam MultipartFile file
            ){
        employeeService.uploadProfileImage(id , file);
        return ResponseEntity.ok("image uploaded");

    }
    @GetMapping("/{id}/profile-image")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id){
        byte[] image = employeeService.getProfileImage(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

}
