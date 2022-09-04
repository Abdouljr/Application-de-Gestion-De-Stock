package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.EntrepriseRepository;
import com.abdouljr.GestionDeStock.Services.EntrepriseService;
import com.abdouljr.GestionDeStock.Validator.EntrepriseValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    public EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto sauvegarder(EntrepriseDto entrepriseDto) {
        List<String> erreurs = EntrepriseValidator.valider(entrepriseDto);
        if (!erreurs.isEmpty()){
            log.error("Cet Entreprise n'est pas valide");
            throw new ExceptionEntiteInvalide("Cet Entreprise n'est pas valide", CodesErreurs.ENTREPRISE_NOT_VALID, erreurs);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto recupererParId(Integer id) {
        if (id == null){
            log.error("Entreprise ID est null");
            return null;
        }
        return entrepriseRepository.findById(id.longValue())
                .map(EntrepriseDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune entreprise avec ID= " + id + " n'est trouvé dans" +
                        "la BDD", CodesErreurs.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto recupererParNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Entreprise Numéro est null");
            return null;
        }
        return entrepriseRepository.findByNom(nom)
                .map(EntrepriseDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune Entreprise avec ce Nom= " + nom + " n'est" +
                        "trouvé dans la BDD", CodesErreurs.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> recupererTout() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Cet Entreprise ID est null");
            return;
        }
        entrepriseRepository.deleteById(id.longValue());
    }
}
