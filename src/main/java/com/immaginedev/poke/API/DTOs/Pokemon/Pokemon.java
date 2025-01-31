package com.immaginedev.poke.API.DTOs.Pokemon;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    
        @JsonProperty("forms")
        private List<Form> forms;
    
        private String id;

        // Getters & Setters
        public List<Form> getForms() {
            return forms;
        }    

        public void setForms(List<Form> forms) {
            this.forms = forms;
        }    

        public String getId() {
            return id;
        }    

        public void setId(String id) {
            this.id = id;
        }    
        
}