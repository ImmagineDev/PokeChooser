package com.immaginedev.poke.API.DTOs.Pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form {

    @JsonProperty("name")
    private String name;
    
    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}