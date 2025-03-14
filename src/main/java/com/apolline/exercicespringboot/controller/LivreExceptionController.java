package com.apolline.exercicespringboot.controller;

import com.apolline.exercicespringboot.exception.LivreNotFoundException;
import com.apolline.exercicespringboot.exception.NoLivreFoundException;
import com.apolline.exercicespringboot.exception.SaveLivreExistException;
import com.apolline.exercicespringboot.exception.UpdateLivreNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> LivreNotFound(LivreNotFoundException livreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", livreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoLivreFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> noLivres(NoLivreFoundException noLivreFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", noLivreFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveLivreExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> saveLivres(SaveLivreExistException saveLivreExist) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", saveLivreExist.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(UpdateLivreNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseEntity<Map<String, String>> updateLivres(UpdateLivreNotFound updateLivreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", updateLivreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}
