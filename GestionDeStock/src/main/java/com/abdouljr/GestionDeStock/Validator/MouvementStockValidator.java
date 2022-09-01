package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.MouvementStockDto;

import java.util.ArrayList;
import java.util.List;

public class MouvementStockValidator {
    public List<String> valider(MouvementStockDto dto) {
        List<String> erreurs = new ArrayList<>();

        if(dto == null || dto.getQuantite() == null){
            erreurs.add("Veillez renseigner la quantité de la ligne de vente !");
       }
        return erreurs;
    }

}
