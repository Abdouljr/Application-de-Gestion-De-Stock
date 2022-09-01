package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public List<String> valider(LigneCommandeFournisseurDto dto) {
        List<String> erreurs = new ArrayList<>();

        if(dto == null){
            erreurs.add("Veillez renseigner la quantité de la ligne de commande Fournisseur !");
            erreurs.add("Veillez renseigner le prix unitaire de la ligne de commande Fournisseur !");
        }else {
            if (dto.getQuantite() == null){
                erreurs.add("Veillez renseigner la quantité de la ligne de commande Fournisseur !");
            }
            if (dto.getPrixUnitaire() == null){
                erreurs.add("Veillez renseigner le prix unitaire de la ligne de commande Fournisseur !");
            }
        }
        return erreurs;
    }
}
