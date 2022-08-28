package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Entreprises")
public class Entreprise extends EntiteAbstraite{

    private String nom;
    private String description;
    @Embedded
    private Adresse adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numero;

    @OneToMany(mappedBy = "entreprise")
    List<Utilisateur> utilisateurs;
}
