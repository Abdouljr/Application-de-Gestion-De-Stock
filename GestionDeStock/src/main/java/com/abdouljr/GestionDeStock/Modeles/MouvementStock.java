package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "Mouvementes_des_stocks")
public class MouvementStock extends EntiteAbstraite{

    private Instant dateMvt;
    private BigDecimal quantite;

    @ManyToOne
    private Article article;

}
