package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Vente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class VenteDto {

    private Integer id;
    private String codeVente;
    private Instant dateVente;
    private String commentaire;

    @JsonIgnore
    List<LigneVenteDto> ligneVentes;

    public static VenteDto fromEntity(Vente vente){
        if (vente == null){
            return null;
        }

        return VenteDto.builder()
                .id(vente.getId())
                .codeVente(vente.getCodeVente())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto){
        if (venteDto == null){
            return null;
        }

        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCodeVente(venteDto.getCodeVente());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}


