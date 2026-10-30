package com.coding.module1introduction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String age;
    private String email;
    private boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;

    public EmployeeDTO() {

    }
    public EmployeeDTO(Long id, String name, String age, String email, boolean isActive, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }
}
