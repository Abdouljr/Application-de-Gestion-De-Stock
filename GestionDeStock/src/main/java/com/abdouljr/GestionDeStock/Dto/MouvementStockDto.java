package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.MouvementStock;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder  // Va nous permettre d'exposer nos données
@Data
public class MouvementStockDto {

    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;

    @JsonIgnore
    private ArticleDto article;

    public MouvementStockDto fromEntity(MouvementStock mouvementStock){
        if (mouvementStock == null){
            return null;
        }

        return MouvementStockDto.builder()
                .id(mouvementStock.getId())
                .dateMvt(mouvementStock.getDateMvt())
                .quantite(mouvementStock.getQuantite())
                .build();
    }

    public MouvementStock toEntity(MouvementStockDto mouvementStockDto){
        if (mouvementStockDto == null){
            return null;
        }

        MouvementStock mouvementStock = new MouvementStock();
        mouvementStock.setId(mouvementStockDto.getId());
        mouvementStock.setDateMvt(mouvementStockDto.getDateMvt());
        mouvementStock.setQuantite(mouvementStockDto.getQuantite());
        return mouvementStock;
    }
}
