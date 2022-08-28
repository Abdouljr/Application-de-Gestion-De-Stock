package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "Utilisateurs")
public class Utilisateur extends EntiteAbstraite {

    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;
    @Embedded
    private Adresse adresse;
    private String photo;

    @OneToMany(mappedBy = "utilisateur")
    List<Roles> roles;

    @ManyToOne
    private Entreprise entreprise;

}
