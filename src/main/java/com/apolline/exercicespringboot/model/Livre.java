package com.apolline.exercicespringboot.model;

import jakarta.persistence.*;

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
    private String titre;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "date_publication", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_publication;

    @Column(name = "auteur", nullable = true)
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
    private List<Genre> genre = new ArrayList<>();

    // Constructeurs
    public Livre () {
    }

    public Livre(String titre, String description, Date date_publication, String auteur) {
        this.titre = titre;
        this.description = description;
        this.date_publication = date_publication;
        this.auteur = auteur;
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
}