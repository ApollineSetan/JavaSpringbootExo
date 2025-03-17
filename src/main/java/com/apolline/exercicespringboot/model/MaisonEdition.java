package com.apolline.exercicespringboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "maison_edition")

public class MaisonEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="libelle", nullable = false)
    @NotBlank(message = "Le nom doit être renseigné")
    @Size(min = 2, message ="Le nom doit posséder au moins deux caractères")
    private String libelle;

    @Column(name="description", nullable = false)
    @NotNull(message = "La description doit être renseignée")
    @Size(min = 5, message ="La description doit posséder au moins cinq caractères")
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
