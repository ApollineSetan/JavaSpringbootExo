package com.apolline.exercicespringboot.exception;

public class NoLivreFoundException extends RuntimeException {
  public NoLivreFoundException() {
    super("Aucun livre dans la base de données");
  }
}
