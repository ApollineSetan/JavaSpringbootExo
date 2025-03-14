package com.apolline.exercicespringboot.exception;

public class UpdateLivreNotFound extends RuntimeException {
    public UpdateLivreNotFound(Long id) {
        super("Le livre avec l'id " + id + " que vous souhaitez modifier n'existe pas");
    }
}
