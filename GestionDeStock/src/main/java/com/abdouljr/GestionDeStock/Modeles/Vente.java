package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "Ventes")
public class Vente extends EntiteAbstraite{

    private String codeVente;
    private Instant dateVente;
    private String commentaire;

    @OneToMany(mappedBy = "vente")
    List<LigneVente> ligneVentes;
}
