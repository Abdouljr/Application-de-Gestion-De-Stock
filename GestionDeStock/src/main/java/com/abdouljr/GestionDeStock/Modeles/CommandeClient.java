package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "Commandes_clients")
public class CommandeClient extends EntiteAbstraite{

    private  String codeClient;
    private Instant dateCommande;

    @OneToMany(mappedBy = "commandeClient")
    List<LigneCommandeClient> ligneCommandeClients;
    @ManyToOne
    private Client client;

}
