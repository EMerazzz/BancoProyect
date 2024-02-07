package com.informatica.BancoProyect.models;

import lombok.Data;

@Data
public class ServiceResponse {
    private Boolean success;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
