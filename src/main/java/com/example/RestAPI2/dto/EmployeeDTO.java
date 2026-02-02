package com.example.RestAPI2.dto;

import java.util.Date;

public class EmployeeDTO {

    private Integer id;

    private String Name;

    private String email;

    private String department;

    private Date createdAt;

    private byte[] profilePicture;
    private String pictureType;
    public String getPictureType() { return pictureType; }
    public void setPictureType(String pictureType) { this.pictureType = pictureType; }
    public EmployeeDTO(){

    }

    public EmployeeDTO(Integer id, String name, String email, String department, Date createdAt, byte[] profilePicture, String pictureType) {
        this.id = id;
        Name = name;
        this.email = email;
        this.department = department;
        this.createdAt = createdAt;
        this.profilePicture = profilePicture;
        this.pictureType = pictureType;
    }

    public Integer getId() {
        return id;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
