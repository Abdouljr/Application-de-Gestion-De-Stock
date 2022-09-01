package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public List<String> valider(EntrepriseDto dto) {
        List<String> erreurs = new ArrayList<>();

        if (!StringUtils.hasLength(dto.getNom())) {
            erreurs.add("Veillez renseigner le nom de l'entreprise !");

            if (!StringUtils.hasLength(dto.getEmail())) {
                erreurs.add("Veillez renseigner l'email de l'entreprise !");

                if (!StringUtils.hasLength(dto.getNumero())) {
                    erreurs.add("Veillez renseigner le numero de l'entreprise !");
                }

                if (dto.getAdresse() == null) {
                    erreurs.add("Veillez renseigner 'Adresse' de l'entreprise !");
                } else {
                    if (!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
                        erreurs.add("Veillez renseigner 'Adresse1' de l'entreprise !");
                    }
                    if (!StringUtils.hasLength(dto.getAdresse().getVille())) {
                        erreurs.add("Veillez rensegner 'Ville' de l'entreprise !");
                    }
                    if (!StringUtils.hasLength(dto.getAdresse().getCodePostale())) {
                        erreurs.add("Veillez rensegner 'Code postale' de l'entreprise !");
                    }
                    if (!StringUtils.hasLength(dto.getAdresse().getPays())) {
                        erreurs.add("Veillez rensegner 'Pays' de l'entreprise !");
                    }
                }

            }
        }
        return erreurs;
    }
}

