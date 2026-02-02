package com.example.RestAPI2.dto;

import jakarta.persistence.Column;

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

    @Column(nullable = false)
    private String password;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Integer id, String Name, String email, String department, Date createdAt, byte[] profilePicture, String pictureType) {
        this.id = id;
        this.Name = Name;
        this.email = email;
        this.department = department;
        this.createdAt = createdAt;
        this.profilePicture = profilePicture;
        this.pictureType = pictureType;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setName(String Name) {
         Name = Name;
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
