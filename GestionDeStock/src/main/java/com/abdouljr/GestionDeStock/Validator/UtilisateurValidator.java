package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> valider(UtilisateurDto utilisateurDto){
        List<String> erreurs = new ArrayList<>();

        if(utilisateurDto == null){
            erreurs.add("Veillez rensegner le nom d'utilisateur !");
            erreurs.add("Veillez rensegner le prénom d'utilisateur !");
            erreurs.add("Veillez rensegner l'email d'utilisateur !");
            erreurs.add("Veillez rensegner le mot de passe utilisateur !");
            erreurs.add("Veillez rensegner la date de naissance de l'utilisateur !");

        }else {
            if (!StringUtils.hasLength(utilisateurDto.getNom())){
                erreurs.add("Veillez rensegner le nom d'utilisateur !");
            }
            if (!StringUtils.hasLength(utilisateurDto.getPrenom())){
                erreurs.add("Veillez rensegner le prénom d'utilisateur !");
            }
            if (!StringUtils.hasLength(utilisateurDto.getEmail())){
                erreurs.add("Veillez rensegner l'email d'utilisateur !");
            }
            if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
                erreurs.add("Veillez rensegner le mot de passe utilisateur !");
            }
            if (utilisateurDto.getDateDeNaissance() == null){
                erreurs.add("Veillez rensegner la date de naissance de l'utilisateur !");
            }

        }

        assert utilisateurDto != null;  // Affirme que utilisateurDto est différent de null pour continuer le test
        if (utilisateurDto.getAdresse() == null){
            erreurs.add("Veillez rensegner 'Adresse' utilisateur !");
        }else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                erreurs.add("Veillez rensegner adresse1 de l'utilisateur !");
            }
                 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                erreurs.add("Veillez rensegner 'Ville' de l'utilisateur !");
            }
                 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                erreurs.add("Veillez rensegner 'Code postale' de l'utilisateur !");
            }
                 if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                erreurs.add("Veillez rensegner 'Pays' de l'utilisateur !");
            }
        }
      return erreurs;
    }
}
