package com.apolline.exercicespringboot.model;

import jakarta.persistence.*;

import java.util.Date;

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

    // Constructeurs
    public Livre () {
    }

    public Livre(String titre, String description, Date date_publication) {
        this.titre = titre;
        this.description = description;
        this.date_publication = date_publication;
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

    // Méthode toString
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date_publication=" + date_publication +
                '}';
    }
}