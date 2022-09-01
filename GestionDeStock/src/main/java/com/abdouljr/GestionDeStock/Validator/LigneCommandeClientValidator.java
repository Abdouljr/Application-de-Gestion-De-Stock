package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public List<String> valider(LigneCommandeClientDto dto) {
        List<String> erreurs = new ArrayList<>();

        if(dto == null){
            erreurs.add("Veillez renseigner la quantité de la ligne de commande client !");
            erreurs.add("Veillez renseigner le prix unitaire de la ligne de commande client !");
        }else {
            if (dto.getQuantite() == null){
                erreurs.add("Veillez renseigner la quantité de la ligne de commande client !");
            }
            if (dto.getPrixUnitaire() == null){
                erreurs.add("Veillez renseigner le prix unitaire de la ligne de commande client !");
            }
        }
        return erreurs;
    }
}
