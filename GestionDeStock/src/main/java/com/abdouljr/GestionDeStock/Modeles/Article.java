package com.abdouljr.GestionDeStock.Modeles;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Articles")
public class Article extends EntiteAbstraite{

    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt; //prix hors tva
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;

    @ManyToOne
    private Categorie categorie;


    @OneToMany(mappedBy = "article")
    List<MouvementStock> mouvementStocks;
    @ManyToOne
    private LigneCommandeFournisseur ligneCommandeFournisseur;

    @ManyToOne
    private LigneCommandeClient ligneCommandeClient;

}
