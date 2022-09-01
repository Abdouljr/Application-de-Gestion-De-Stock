package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public List<String> valider(FournisseurDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veillez rensigner le nom du fournisseur !");
            erreurs.add("Veillez rensigner le prénom du fournisseur !");
            erreurs.add("Veillez rensigner l'email du fournisseur !");
            erreurs.add("Veillez rensigner le numero de télephone du fournisseur !");
        }else {
            if (!StringUtils.hasLength(dto.getNom())){
                erreurs.add("Veillez rensigner le nom du fournisseur !");
            }
            if (!StringUtils.hasLength(dto.getPrenom())){
                erreurs.add("Veillez rensigner le prénom du fournisseur !");
            }
            if (!StringUtils.hasLength(dto.getEmail())){
                erreurs.add("Veillez rensigner l'email du fournisseur !");
            }
            if (!StringUtils.hasLength(dto.getNumero())){
                erreurs.add("Veillez rensigner le numero de télephone du fournisseur !");
            }

        }
        return erreurs;
    }
}
