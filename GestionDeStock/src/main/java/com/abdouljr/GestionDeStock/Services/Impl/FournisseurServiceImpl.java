package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.FournisseurDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.FournisseurRepository;
import com.abdouljr.GestionDeStock.Services.FournisseurService;
import com.abdouljr.GestionDeStock.Validator.FournisseurValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    public FournisseurRepository fournisseurRepository;
    @Override
    public FournisseurDto sauvegarder(FournisseurDto fournisseurDto) {
        List<String> erreurs = FournisseurValidator.valider(fournisseurDto);
        if (!erreurs.isEmpty()){
            log.error("Ce Fournisseur n'est pas valide");
            throw new ExceptionEntiteInvalide("Ce Fournisseur n'est pas valide", CodesErreurs.FOURNISSEUR_NOT_VALID, erreurs);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto recupererParId(Integer id) {
        if (id == null){
            log.error("Fournisseur ID est null");
            return null;
        }
        return fournisseurRepository.findById(id.longValue())
                .map(FournisseurDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun fournisseur avec cet ID= " + id + " n'est " +
                        "trouvé dans la BDD", CodesErreurs.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public FournisseurDto recupererParNumero(String numero) {
        if (!StringUtils.hasLength(numero)){
            log.error("Ce numero est null");
            return null;
        }
        return fournisseurRepository.findByNumero(numero)
                .map(FournisseurDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun fournisseur avec ce numero= " + numero + " n'est" +
                        " trouvé dans la BDD", CodesErreurs.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> recupererTout() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Fournisseur ID est null");
            return;
        }
            fournisseurRepository.deleteById(id.longValue());
    }
}
