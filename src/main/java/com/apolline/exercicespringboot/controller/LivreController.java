package com.apolline.exercicespringboot.controller;

import com.apolline.exercicespringboot.dto.LivreDto;
import com.apolline.exercicespringboot.exception.LivreNotFoundException;
import com.apolline.exercicespringboot.model.Livre;
import com.apolline.exercicespringboot.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // Récupérer tous les livres
    @GetMapping("/livres")
    public Iterable<Livre> findAll() {
        return livreService.getAllLivres();
    }

    // Récupérer un livre par son ID
    @GetMapping("/livre/{id}")
    public Livre getLivreById(@PathVariable Integer id) {
        return livreService.getById(id).orElseThrow(
                ()-> new LivreNotFoundException(id)
        );
    }

    // Créer un livre
    @PostMapping("/livre")
    @ResponseStatus(HttpStatus.CREATED)
    public String createLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    // Modifier un livre
    @PutMapping("/livre/{id}")
    public Livre updateLivre(@PathVariable Long id,@RequestBody Livre livre) {
        return livreService.updateLivre(id, livre);
    }

    // Supprimer un livre
    @DeleteMapping("/livre/{id}")
    public String deleteLivre(@PathVariable Long id) {
        return livreService.deleteLivre(id);
    }

    // Récupérer tous les livres
    @GetMapping("/livre/dto")
    public List<LivreDto> findAllDto() {
        return livreService.getAllLivreDto();
    }

    @GetMapping("/livre/dto/{id}")
    public Stream<LivreDto> getLivreById(@PathVariable Long id) {
        return livreService.getLivreDtoById(id);
    }
}
