package com.example.RestAPI2.controller;

import com.example.RestAPI2.service.VersionTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeHeaderVersioning {

    private VersionTestService versionTestService ;
    public EmployeeHeaderVersioning(VersionTestService versionTestService){
        this.versionTestService = versionTestService;
    }
    @GetMapping(value = "/employees" , headers = "api-version=1")
    public ResponseEntity<Map<String, Object>> v1(){
        Map<String, Object> body = Map.of(
                "version", "v1",
                "data", versionTestService.getEmployeeV1()
        );
        return ResponseEntity.ok(body);
    }
    @GetMapping(value = "/employees" , headers = "api-version=2")
    public ResponseEntity<Map<String, Object>> v2(){
        Map<String, Object> body = Map.of(
                "version", "v2",
                "data", versionTestService.getEmployeeV2()
        );
        return ResponseEntity.ok(body);
    }
}


