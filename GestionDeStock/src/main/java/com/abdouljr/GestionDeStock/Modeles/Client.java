package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Clients")
public class Client extends EntiteAbstraite{

    private String nom;
    private String prenom;
    @Embedded
    private Adresse adresse;  //  @Embedded est utilisée pour incorporer un type dans une autre entité.
    private String photo;
    private String email;
    private String numero;

    @OneToMany(mappedBy = "client")
    List<CommandeClient> commandeClients;
}
