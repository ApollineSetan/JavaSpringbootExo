package com.apolline.exercicespringboot.controller;

import com.apolline.exercicespringboot.model.Livre;
import com.apolline.exercicespringboot.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // Récupérer tous les livres
    @GetMapping("/list")
    public Iterable<Livre> findAll() {
        return livreService.getAllLivres();
    }

    // Récupérer un livre par son ID
    @GetMapping("/livre/{id}")
    public String findById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    // Créer un livre
    @PostMapping("/create")
    public String createLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    // Modifier un livre
    @PutMapping("/update/{id}")
    public String updateLivre(@PathVariable Long id,@RequestBody Livre livre) {
        return livreService.updateLivre(id, livre);
    }

    // Supprimer un livre
    @DeleteMapping("/delete/{id}")
    public String deleteLivre(@PathVariable Long id) {
        return livreService.deleteLivre(id);
    }
}
