package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;
import com.abdouljr.GestionDeStock.Dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public List<String> valider(CommandeFournisseurDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getCodeFournisseur())){
            erreurs.add("Veillez renseigner le code fournisseur du commande fournisseur !");
        }
        return erreurs;
    }
}
