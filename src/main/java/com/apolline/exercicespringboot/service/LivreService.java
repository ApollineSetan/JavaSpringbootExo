package com.apolline.exercicespringboot.service;

import com.apolline.exercicespringboot.model.Livre;
import com.apolline.exercicespringboot.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    // Récupérer tous les livres
    public Iterable<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par son ID
    public Livre getLivreById(Long id) {
        Optional<Livre> livre = livreRepository.findById(id);
        return livre.orElse(null);
    }

    // Créer un livre
    public String saveLivre(Livre livre) {
        if (livre.getTitre() == null || livre.getTitre().isEmpty()) {
            return ("Vous n'avez pas mis de titre");
        } else if (livre.getDescription() == null || livre.getDescription().isEmpty()) {
            return ("Vous n'avez pas mis de description");
        } else if (livre.getDate_publication() == null) {
            return ("Vous n'avez pas mis de date");
        } else {
            livreRepository.save(livre);
            return ("Livre ajouté avec succès");
        }
    }

    // Modifier un livre
    public Livre updateLivre(Long id, Livre livre) {
        Optional<Livre> livreOptional = livreRepository.findById(id);

        if (livreOptional.isPresent()) {
            Livre livreToUpdate = livreOptional.get();
            livreToUpdate.setTitre(livre.getTitre());
            livreToUpdate.setDescription(livre.getDescription());
            livreToUpdate.setDate_publication(livre.getDate_publication());
            return livreRepository.save(livreToUpdate);
        } else {
            return null;
        }
    }

    // Supprimer un livre
    public String deleteLivre(Long id) {
        Optional<Livre> livreOptional = livreRepository.findById(id);

        if (livreOptional.isPresent()) {
            livreRepository.deleteById(id);
            return ("Le livre a bien été supprimé.");
        } else {
            return ("Erreur.");
        }
    }

}