package com.abdouljr.GestionDeStock.Dto;


import com.abdouljr.GestionDeStock.Modeles.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class CommandeFournisseurDto {

    private Integer id;
    private  String codeFournisseur;
    private Instant dateCommande;

    @JsonIgnore
    List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    @JsonIgnore
    private FournisseurDto fournisseur;

    public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
        }

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .codeFournisseur(commandeFournisseur.getCodeFournisseur())
                .dateCommande(commandeFournisseur.getDateCommande())
                .build();
    }

    public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if (commandeFournisseurDto == null){
            return null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCodeFournisseur(commandeFournisseurDto.getCodeFournisseur());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        return commandeFournisseur;
    }
}
