package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

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


}
