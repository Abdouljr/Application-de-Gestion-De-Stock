package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.LigneCommandeFournisseurDto;
import com.abdouljr.GestionDeStock.Dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public List<String> valider(LigneVenteDto dto) {
        List<String> erreurs = new ArrayList<>();

        if(dto == null){
            erreurs.add("Veillez renseigner la quantité de la ligne de vente !");
            erreurs.add("Veillez renseigner le prix unitaire de la ligne de vente !");
        }else {
            if (dto.getQuantite() == null){
                erreurs.add("Veillez renseigner la quantité de la ligne de vente !");
            }
            if (dto.getPrixUnitaire() == null){
                erreurs.add("Veillez renseigner le prix unitaire de la ligne de vente !");
            }
        }
        return erreurs;
    }

}
