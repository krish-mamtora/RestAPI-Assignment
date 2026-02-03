package com.example.RestAPI2.dto;

import java.time.Instant;
import java.util.Date;

public class EmployeeResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private Date creatdAt;
    private String department;
    public Integer getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatdAt() {
        return creatdAt;
    }

    public void setCreatdAt(Date creatdAt) {
        this.creatdAt = creatdAt;
    }
}
