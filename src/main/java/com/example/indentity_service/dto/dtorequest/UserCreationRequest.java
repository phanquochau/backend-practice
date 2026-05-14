package com.example.indentity_service.dto.dtorequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {
    @NotBlank(message = "USERNAME_INVALID")
    @Size(min = 3, max = 20,
            message = "USERNAME_INVALID")
    @Pattern(
            regexp = "^[A-Za-z][A-Za-z0-9_]{2,19}$",
            message = "USERNAME_INVALID"
    )
    private String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String firstname;
    private String lastname;

    private LocalDate dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}