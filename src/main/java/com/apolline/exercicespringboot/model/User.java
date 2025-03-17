package com.apolline.exercicespringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable = false)
    @NotBlank(message = "Le prénom doit être renseigné")
    @Size(min = 2, message ="Le prénom doit posséder au moins deux caractères")
    private String firstname;

    @Column(name="lastname", nullable = false)
    @NotBlank(message = "Le nom doit être renseigné")
    @Size(min = 2, message ="Le nom doit posséder au moins deux caractères")
    private  String lastname;

    @Column(name= "email", nullable = false, unique = true)
    @NotBlank(message = "L'email doit être renseigné")
    @Email(message = "Le mail doit être valide")
    private String email;

    @Column(name="password", nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@!])(?=\\S+$).{8,20}$", message = "Le mot de passe doit contenir au moins un chiffre, une lettre, un caractère spécial et pas d'espace")
    private String password;

    public User() {}

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
