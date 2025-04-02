package com.example.fashionapp.backend.dto;

import com.example.fashionapp.backend.model.TipUtilizator;
import lombok.Getter;


@Getter
public class LoginRequest {

    private String email;
    private String password;
    private String role;

    // Constructori, getter și setter

    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
