package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class ArticleDto {

    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt; //prix hors tva
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;

    private CategorieDto categorie;

    @JsonIgnore
    List<MouvementStockDto> mouvementStocks;

    @JsonIgnore
    private LigneCommandeFournisseurDto ligneCommandeFournisseur;

    @JsonIgnore
    private LigneCommandeClientDto ligneCommandeClient;

    public ArticleDto fromEntity(Article article){
        if (article == null){
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .build();
    }

    public Article toEntity(ArticleDto articleDto){
        if (articleDto == null){
            return null;
        }

        Article article = new Article();
        article.setId((articleDto.getId()));
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        return article;
    }
}
