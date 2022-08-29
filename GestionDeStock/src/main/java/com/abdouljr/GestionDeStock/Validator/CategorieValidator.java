package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {

    public static List<String> validator(CategorieDto categorieDto){
        List<String> erreurs = new ArrayList<>();

        // StringUtils.hasLength pour vérifier si le contenu est vide comme getCodeCategorie.IsEmpty ou IsBlank
        if (categorieDto == null || !StringUtils.hasLength(categorieDto.getCodeCategorie())){
             erreurs.add("Veillez rensegner le code de la catégorie !");
        }
        return erreurs;
    }

}
