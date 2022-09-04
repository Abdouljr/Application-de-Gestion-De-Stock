package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> valider(CommandeClientDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veillez renseigner le code client du commande client !");
        }else {

            if (!StringUtils.hasLength(dto.getCodeClient())){
                erreurs.add("Veillez renseigner le code client du commande client !");
            }
            if (dto.getClient() == null){
                erreurs.add("Veillez renseigner l'ID client du commande client !");

            }
        }
        return erreurs;
    }
}
