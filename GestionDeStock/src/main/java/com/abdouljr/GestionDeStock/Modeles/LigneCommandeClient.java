package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Lignes_des_commandes_clients")
public class LigneCommandeClient extends EntiteAbstraite{

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

    @OneToMany(mappedBy = "ligneCommandeClient")
    List<Article> articles;
    @ManyToOne
    private CommandeClient commandeClient;

}
