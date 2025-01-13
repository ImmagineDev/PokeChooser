package com.immaginedev.poke.API.Exceptions;

public class PokemonNotFound extends RuntimeException {
    public PokemonNotFound(String message) {
        super(message);
    }
}
