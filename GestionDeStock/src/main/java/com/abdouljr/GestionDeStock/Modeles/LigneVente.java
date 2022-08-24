package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Lignes_des_ventes")
public class LigneVente extends EntiteAbstraite{
}
