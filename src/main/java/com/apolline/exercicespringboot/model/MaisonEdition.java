package com.apolline.exercicespringboot.model;


import jakarta.persistence.*;

@Entity
@Table(name = "maison_edition")

public class MaisonEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="libelle", nullable = false)
    private String libelle;

    @Column(name="description", nullable = false)
    private  String description;

    public MaisonEdition() {}

    public MaisonEdition(Integer id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
