package com.example.RestAPI2.service;

import org.springframework.stereotype.Service;

@Service
public class VersionTestService {
    public String getEmployeeV1(){
        return "THis is V1 api";
    }
    public String getEmployeeV2(){
        return "THis is V2 api";
    }

}
