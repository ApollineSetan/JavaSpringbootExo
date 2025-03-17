package com.apolline.exercicespringboot.service;


import com.apolline.exercicespringboot.dto.LivreDto;
import com.apolline.exercicespringboot.model.Genre;
import com.apolline.exercicespringboot.model.Livre;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Service
public class LivreDtoWrapper {

    public LivreDto livreToDto(Livre livre) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(livre.getDate_publication());

        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getDescription(),
                livre.getMaisonEdition().getLibelle(),
                formattedDate,
                livre.getGenre().stream().map(Genre::getName).collect(Collectors.toList())
        );
    }
}
