package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Roles extends EntiteAbstraite{

    private String role;

    @ManyToOne
    private Utilisateur utilisateur;
}
