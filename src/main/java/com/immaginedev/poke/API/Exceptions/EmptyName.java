package com.immaginedev.poke.API.Exceptions;

public class EmptyName extends RuntimeException {
    public EmptyName(String message) {
        super(message);
    }
}