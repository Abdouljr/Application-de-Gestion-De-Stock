package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public List<String> validator(CommandeClientDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getCodeClient())){
            erreurs.add("Veillez renseigner le code client du commande client !");
        }
        return erreurs;
    }
}
