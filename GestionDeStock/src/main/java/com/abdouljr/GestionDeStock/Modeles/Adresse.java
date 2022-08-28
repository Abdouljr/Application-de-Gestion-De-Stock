package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable  // @Embeddable  pour déclarer qu'une classe sera intégrée par d'autres entités.
public class Adresse {

    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;
}
