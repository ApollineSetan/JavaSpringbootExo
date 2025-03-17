package com.apolline.exercicespringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="livre")
public class Livre {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Le titre doit être renseigné")
    @Size(min = 3, message ="Le titre doit posséder au moins trois caractères")
    private String titre;

    @Column(name = "description", nullable = false, length = 255)
    @NotBlank(message = "La description doit être renseignée")
    @Size(min = 5, message ="La description doit posséder au moins cinq caractères")
    private String description;

    @Column(name = "date_publication", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La date de publication doit être renseignée")
    @Past(message = "La date de publication doit être passée")
    @FutureOrPresent(message = "La date de publication ne peut pas être dans le futur")
    private Date date_publication;

    @Column(name = "auteur", nullable = true)
    @NotNull(message = "L'auteur doit être renseigné")
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_maison_edition")
    private MaisonEdition maisonEdition;

    @ManyToMany
    @JoinTable(name = "livre_genre",
    joinColumns = @JoinColumn(name = "livre_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genre;

    // Constructeurs
    public Livre () {
        this.genre = new ArrayList<>();
    }

    public Livre(String titre, String description, Date date_publication, String auteur) {
        this.titre = titre;
        this.description = description;
        this.date_publication = date_publication;
        this.auteur = auteur;
        this.genre = new ArrayList<>();
    }

    public Livre(String titre, String description, Date date_publication, String auteur, MaisonEdition maisonEdition) {
        this.titre = titre;
        this.description = description;
        this.date_publication = date_publication;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date_publication=" + date_publication +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    public void addGenre(Genre genre) {
        this.genre.add(genre);
    }

    public void removeGenre(Genre genre) {
        this.genre.remove(genre);
    }
}