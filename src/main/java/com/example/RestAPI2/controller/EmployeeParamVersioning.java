package com.example.RestAPI2.controller;

import com.example.RestAPI2.service.VersionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeParamVersioning {
    @Autowired
    VersionTestService versionTestService ;

    @GetMapping(value = "/employees" , params = "virsion=1")
    public ResponseEntity<?> v1(){
        return ResponseEntity.ok(
                Map.of("version", "v1","data", versionTestService.getEmployeeV1())
        );
    }
    @GetMapping(value = "/employees" , params = "virsion=2")
    public ResponseEntity<?>v2(){
        return ResponseEntity.ok(
                Map.of("version", "v2","data", versionTestService.getEmployeeV2())
        );
    }
}
