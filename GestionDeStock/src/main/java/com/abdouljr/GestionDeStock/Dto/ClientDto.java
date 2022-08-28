package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Adresse;
import com.abdouljr.GestionDeStock.Modeles.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class ClientDto {

    private Integer id;
    private String nom;
    private String prenom;
    @Embedded
    private Adresse adresse;  //  @Embedded est utilisée pour incorporer un type dans une autre entité.
    private String photo;
    private String email;
    private String numero;

    @JsonIgnore
    List<CommandeClientDto> commandeClients;

    public ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .numero(client.getNumero())
                .build();
    }

    public Client toEntity(ClientDto clientDto){
        if (clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(clientDto.getAdresse());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setNumero(clientDto.getNumero());
        return client;
    }
}
