package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validator(ArticleDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veillez rensegner le code de l'article !");
            erreurs.add("Veillez rensegner la désignation de l'article !");
            erreurs.add("Veillez rensegner le prix unitaire HT de l'article !");
            erreurs.add("Veillez rensegner le prix unitaire TTC de l'article !");
            erreurs.add("Veillez rensegner le taux TVA de l'article !");
            erreurs.add("Selection la catégorie de l'article !");
        }else {
            // on peut faire "dto.getCodeArticle().isEmpty()" si ça contient quelque chose ça retourne false
            if(!StringUtils.hasLength(dto.getCodeArticle())){
                erreurs.add("Veillez rensegner le code de l'article !");
            }
            if(!StringUtils.hasLength(dto.getDesignation())){
                erreurs.add("Veillez rensegner la désignation de l'article !");
            }
            if(dto.getPrixUnitaireHt() == null){
                erreurs.add("Veillez rensegner le prix unitaire HT de l'article !");
            }
            if(dto.getTauxTva() == null){
                erreurs.add("Veillez rensegner le taux TVA de l'article !");
            }
            if(dto.getPrixUnitaireTtc() == null){
                erreurs.add("Veillez rensegner le prix unitaire TTC de l'article !");
            }
             if(dto.getCodeArticle() == null){
                erreurs.add("Veillez selectionner la catégorie de l'article !");
            }
        }


        return erreurs;
    }
}
