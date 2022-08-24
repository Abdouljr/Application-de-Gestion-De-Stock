package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Lignes_des_commandes_fournisseurs")
public class LigneCommandeFournisseur extends EntiteAbstraite{
}
