package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.MouvementStockDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.MouvementStockRepository;
import com.abdouljr.GestionDeStock.Services.MouvementStockService;
import com.abdouljr.GestionDeStock.Validator.MouvementStockValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class MouvementStockServiceImpl implements MouvementStockService {
    @Autowired
    public MouvementStockRepository mouvementStockRepository;

    @Override
    public MouvementStockDto sauvegarder(MouvementStockDto mouvementStockDto) {
        List<String> erreurs = MouvementStockValidator.valider(mouvementStockDto);
        if (!erreurs.isEmpty()){
            log.error("Ce mouvement de Stock n'est pas valide");
            throw new ExceptionEntiteInvalide("Cet mouvement de Stock n'est pas valide", CodesErreurs.MOUVEMENT_STOCK_NOT_VALID, erreurs);
        }
        return MouvementStockDto.fromEntity(mouvementStockRepository.save(MouvementStockDto.toEntity(mouvementStockDto)));

    }

    @Override
    public MouvementStockDto recupererParId(Integer id) {
        if (id == null){
            log.error("Mouvemet de Stock ID est null");
            return null;
        }
        return mouvementStockRepository.findById(id.longValue())
                .map(MouvementStockDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun mouvement de Stock avec cet ID= " + id + " n'est trouvé" +
                        " dans la BDD", CodesErreurs.MOUVEMENT_STOCK_NOT_FOUND));
    }


    @Override
    public List<MouvementStockDto> recupererTout() {
        return mouvementStockRepository.findAll().stream()
                .map(MouvementStockDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Mouvement de Stock ID est null");
            return;
        }
        mouvementStockRepository.deleteById(id.longValue());
    }
}
