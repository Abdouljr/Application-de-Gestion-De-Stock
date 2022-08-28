package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Adresse;
import com.abdouljr.GestionDeStock.Modeles.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class FournisseurDto {

    private Integer id;
    private String nom;
    private String prenom;
    @Embedded
    private Adresse adresse;  //  @Embedded est utilisée pour incorporer un type dans une autre entité.
    private String photo;
    private String email;
    private String numero;

    @JsonIgnore
    List<CommandeFournisseurDto> commandeFournisseurs;

    public FournisseurDto fromEntity(Fournisseur fournisseur){
        if (fournisseur == null){
            return null;
        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(fournisseur.getAdresse())
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .numero(fournisseur.getNumero())
                .build();
    }

    public Fournisseur toEntity(FournisseurDto fournisseurDto){
        if (fournisseurDto == null){
            return null;
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(fournisseurDto.getAdresse());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setNumero(fournisseurDto.getNumero());
        return fournisseur;
    }
}
