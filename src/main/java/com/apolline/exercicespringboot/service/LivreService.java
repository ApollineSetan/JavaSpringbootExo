package com.apolline.exercicespringboot.service;

import com.apolline.exercicespringboot.exception.SaveLivreExistException;
import com.apolline.exercicespringboot.exception.UpdateLivreNotFound;
import com.apolline.exercicespringboot.model.Livre;
import com.apolline.exercicespringboot.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    // Récupérer tous les livres
    public Iterable<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par son ID
    public Optional<Livre> getById(int id){
        return livreRepository.findById((long) id);
    }

    // Créer un livre
    public String saveLivre(Livre livre) {
        for (Livre livre1 : livreRepository.findAll()) {
            if (livre1.getTitre().equals(livre.getTitre())) {
                throw new SaveLivreExistException();
            }
        }
        if (livre.getTitre() == null || livre.getTitre().isEmpty()) {
            return ("Vous n'avez pas mis de titre");
        } else if (livre.getDescription() == null || livre.getDescription().isEmpty()) {
            return ("Vous n'avez pas mis de description");
        } else if (livre.getDate_publication() == null) {
            return ("Vous n'avez pas mis de date");
        }
        livreRepository.save(livre);
        return ("Livre ajouté avec succès");
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
            throw new UpdateLivreNotFound(id);
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