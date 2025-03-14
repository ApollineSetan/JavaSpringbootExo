package com.apolline.exercicespringboot.dto;

public record LivreDto(
        Long id,
        String titre,
        String auteur,
        String date_publication,
        String maisonEdition
) {
}
