package com.apolline.exercicespringboot.exception;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException() {
        super("Un livre avec un titre similaire existe déjà en base de données.");
    }
}
