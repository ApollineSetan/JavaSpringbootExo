package com.apolline.exercicespringboot.exception;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException() {
        super("Le livre avec ces informations existe déjà en base de données.");
    }
}
