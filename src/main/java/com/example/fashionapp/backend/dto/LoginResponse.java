package com.example.fashionapp.backend.dto;

import com.example.fashionapp.backend.model.TipUtilizator;

public class LoginResponse {

    private TipUtilizator role;
    private Long idUtilizator;

    // Constructori, getter și setter

    public LoginResponse() {}

    public LoginResponse(TipUtilizator role,Long idUtilizator) {
        this.role = role;
        this.idUtilizator=idUtilizator;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public TipUtilizator getRole() {
        return role;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public void setRole(TipUtilizator role) {
        this.role = role;
    }
}
