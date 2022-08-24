package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Mouvementes_des_stocks")
public class MouvementStock extends EntiteAbstraite{
}
