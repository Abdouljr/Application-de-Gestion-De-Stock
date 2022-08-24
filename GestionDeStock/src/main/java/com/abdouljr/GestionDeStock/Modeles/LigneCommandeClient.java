package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Lignes_des_commandes_clients")
public class LigneCommandeClient extends EntiteAbstraite{
}
