package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class CommandeClientDto {

    private Integer id;
    private  String codeClient;
    private Instant dateCommande;

    @JsonIgnore
    List<LigneCommandeClientDto> ligneCommandeClients;

    @JsonIgnore
    private ClientDto client;

    public  CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return null;
        }

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .codeClient(commandeClient.getCodeClient())
                .dateCommande(commandeClient.getDateCommande())
                .build();

    }

    public CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if (commandeClientDto == null){
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCodeClient(commandeClientDto.getCodeClient());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        return commandeClient;
    }
}
