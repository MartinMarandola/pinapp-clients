package com.pinappchallenge.app.rest.model.dto;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel(value = "Client Get Response DTO")
public class ClientResDTO {
    private Long id;
    private String name;
    private String lastName;
    private Long age;
    private Date dateOfBirth;
    private Date estimatedDeathDate;

    public ClientResDTO() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getEstimatedDeathDate() {
        return estimatedDeathDate;
    }

    public void setEstimatedDeathDate(Date estimatedDeathDate) {
        this.estimatedDeathDate = estimatedDeathDate;
    }
}
