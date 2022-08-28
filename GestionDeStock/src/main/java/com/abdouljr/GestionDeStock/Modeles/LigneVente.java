package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Lignes_des_ventes")
public class LigneVente extends EntiteAbstraite{

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

    @ManyToOne
    private Vente vente;
}
