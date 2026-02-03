package com.example.RestAPI2.dto;

import java.util.Date;

public class ApiErrorResponse {
    private Date timestamp;
    private int status ;
    private String error ;
    private String message ;
    private String path;

    public ApiErrorResponse(){

    }

    public ApiErrorResponse(Date timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
