package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {
    public List<String> validator(VenteDto dto) {
        List<String> erreurs = new ArrayList<>();

        if(dto == null || !StringUtils.hasLength(dto.getCodeVente())){
            erreurs.add("Veillez renseigner le code de vente !");
        }
        return erreurs;
    }
}
