package com.immaginedev.poke.API.DTOs;

import java.time.LocalDateTime;

public class ErrorResponse {
    
    private String message;
    private String errorType;
    private int statusCode;
    private LocalDateTime timestamp;
    private String path;

    public ErrorResponse(String message, String errorType, int statusCode, LocalDateTime timestamp, String path) {
        this.message = message;
        this.errorType = errorType;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.path = path;
    }

    // Getters & Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}