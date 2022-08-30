package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public List<String> validator(ClientDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veillez rensigner le nom du client !");
            erreurs.add("Veillez rensigner le prénom du client !");
            erreurs.add("Veillez rensigner l'email du client !");
            erreurs.add("Veillez rensigner le numero de télephone du client !");
        }else {
            if (!StringUtils.hasLength(dto.getNom())){
                erreurs.add("Veillez rensigner le nom du client !");
            }
            if (!StringUtils.hasLength(dto.getPrenom())){
                erreurs.add("Veillez rensigner le prénom du client !");
            }
            if (!StringUtils.hasLength(dto.getEmail())){
                erreurs.add("Veillez rensigner l'email du client !");
            }
            if (!StringUtils.hasLength(dto.getNumero())){
                erreurs.add("Veillez rensigner le numero de télephone du client !");
            }

        }
        return erreurs;
    }
}
