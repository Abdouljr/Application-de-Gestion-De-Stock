package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Commandes_fournisseurs")
public class CommandeFournisseur extends EntiteAbstraite{
}
