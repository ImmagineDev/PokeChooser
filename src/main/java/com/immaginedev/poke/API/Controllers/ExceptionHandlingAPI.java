package com.immaginedev.poke.API.Controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.immaginedev.poke.API.DTOs.ErrorResponse;
import com.immaginedev.poke.API.Exceptions.*;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlingAPI {

    @ExceptionHandler({PokemonNotFound.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse PokemonDoNotExist(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                request.getRequestURI());
    }

    @ExceptionHandler({EmptyName.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse NameEmpty(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler({WrongFormat.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse WrongFormatName(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(
                exception.getMessage(),
                exception.getClass().getSimpleName(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                request.getRequestURI()
        );
    }

}