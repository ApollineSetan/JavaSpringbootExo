package com.apolline.exercicespringboot.controller;

import com.apolline.exercicespringboot.exception.LivreNotFoundException;
import com.apolline.exercicespringboot.exception.NoLivreFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String LivreNotFound(LivreNotFoundException livreNotFound) {
        return livreNotFound.getMessage();
    }

    @ExceptionHandler(NoLivreFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noLivres(NoLivreFoundException noLivreFound) {
        return noLivreFound.getMessage();
    }
}
