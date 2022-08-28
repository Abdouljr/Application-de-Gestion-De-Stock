package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Categorie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class CategorieDto {

    private Integer id;
    private String codeCategorie;
    private String designation;

    @JsonIgnore
    List<ArticleDto> articles;

    public CategorieDto fromEntity(Categorie categorie){
        if (categorie == null){
            return null;  // EXCEPTION D'ERREURS
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .codeCategorie(categorie.getCodeCategorie())
                .designation(categorie.getDesignation())
                .build();
    }

    public Categorie toEntity(CategorieDto categorieDto){
        if (categorieDto == null){
            return null;  // EXCEPTION D'ERREURS
        }

        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCodeCategorie(categorieDto.getCodeCategorie());
        categorie.setDesignation(categorieDto.getDesignation());

        return categorie;
    }
}
