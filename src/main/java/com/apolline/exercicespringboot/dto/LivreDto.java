package com.apolline.exercicespringboot.dto;

import java.util.List;

public record LivreDto(
        Long id,
        String titre,
        String content,
        String libelleMaisonEdition,
        String date_publication,
        List<String> genre
) {
}
