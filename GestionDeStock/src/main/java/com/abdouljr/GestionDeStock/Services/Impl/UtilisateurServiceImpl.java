package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.UtilisateurDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.UtilisateurRepository;
import com.abdouljr.GestionDeStock.Services.UtilisateurService;
import com.abdouljr.GestionDeStock.Validator.UtilisateurValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    public UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto sauvegarder(UtilisateurDto utilisateurDto) {
        List<String> erreurs = UtilisateurValidator.valider(utilisateurDto);
        if (!erreurs.isEmpty()){
            log.error("Cet utilisateur n'est pas valide");
            throw new ExceptionEntiteInvalide("Cet utilisateur n'est pas valide", CodesErreurs.UTILISATEUR_NOT_VALID, erreurs);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto recupererParId(Integer id) {
        if (id == null){
            log.error("Utilisateur ID est null");
            return null;
        }
        return utilisateurRepository.findById(id.longValue())
                .map(UtilisateurDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun utilisateur avec cet ID= " + id + " n'est trouvé" +
                        " dans la BDD", CodesErreurs.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> recupererTout() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Utilisateur ID est null");
            return;
        }
        utilisateurRepository.deleteById(id.longValue());
    }
}
