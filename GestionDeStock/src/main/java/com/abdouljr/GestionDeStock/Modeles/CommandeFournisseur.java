package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "Commandes_fournisseurs")
public class CommandeFournisseur extends EntiteAbstraite{


    private  String codeFournisseur;
    private Instant dateCommande;

    @OneToMany(mappedBy = "commandeFournisseur")
    List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @ManyToOne
    private Fournisseur fournisseur;

}
