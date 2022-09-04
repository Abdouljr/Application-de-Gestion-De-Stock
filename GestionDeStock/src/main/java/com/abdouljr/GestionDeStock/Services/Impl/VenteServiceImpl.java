package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.VenteDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.VenteRepository;
import com.abdouljr.GestionDeStock.Services.VenteService;
import com.abdouljr.GestionDeStock.Validator.VenteValidator;
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
public class VenteServiceImpl implements VenteService {

    @Autowired
    public VenteRepository venteRepository;

    @Override
    public VenteDto sauvegarder(VenteDto venteDto) {
        List<String> erreurs = VenteValidator.valider(venteDto);
        if (!erreurs.isEmpty()){
            log.error("Cette vente n'est pas valide");
            throw new ExceptionEntiteInvalide("Cette vente n'est pas valide", CodesErreurs.VENTE_NOT_VALID, erreurs);
        }
        return VenteDto.fromEntity(venteRepository.save(VenteDto.toEntity(venteDto)));
    }

    @Override
    public VenteDto recupererParId(Integer id) {
        if (id == null){
            log.error("Vente ID est nulle");
            return null;
        }
        return venteRepository.findById(id.longValue())
                .map(VenteDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune vente avec cet ID= " + id + " n'est" +
                        " trouvé dans la BDD", CodesErreurs.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDto recupererParCodeVente(String codeVente) {
        if (!StringUtils.hasLength(codeVente)){
            log.error("Cette code vente est null ");
            return null;
        }
        return venteRepository.findByCodeVente(codeVente)
                .map(VenteDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune vente avec cet Code Vente= " + " n'est" +
                        " trouvé dans la BDD", CodesErreurs.VENTE_NOT_FOUND));
    }

    @Override
    public List<VenteDto> recupererTout() {
        return venteRepository.findAll().stream()
                .map(VenteDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Vente ID est null");
            return;
        }
        venteRepository.deleteById(id.longValue());
    }
}
