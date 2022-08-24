package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Fournisseurs")
public class Fournisseur extends EntiteAbstraite{
}
