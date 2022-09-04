package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.CategorieDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.CategorieRepository;
import com.abdouljr.GestionDeStock.Services.CategorieService;
import com.abdouljr.GestionDeStock.Validator.CategorieValidator;
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
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    public CategorieRepository categorieRepository;


    @Override
    public CategorieDto sauvegarder(CategorieDto categorieDto) {
        List<String> erreurs = CategorieValidator.valider(categorieDto);
        if (!erreurs.isEmpty()){
            log.error("Cet article n'est pas valide");
            throw new ExceptionEntiteInvalide("Cet article n'est pas valide", CodesErreurs.CATEGORIE_NOT_VALID, erreurs);
        }

        return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(categorieDto)));
    }

    @Override
    public CategorieDto recupererParId(Integer id) {
        if (id == null){
            log.error("Categorie ID est nulle");
            return null;
        }
        return categorieRepository.findById(id.longValue())
                .map(CategorieDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune Catégorie avec l'ID= " + id + " n'est trouvé" +
                        "dans la BDD", CodesErreurs.CATEGORIE_NOT_FOUND));
    }

    @Override
    public CategorieDto recupererParCodeCategorie(String codeCategorie) {
        if (!StringUtils.hasLength(codeCategorie)){
            log.error("Catégorie Code est nulle");
        }
        return categorieRepository.findByCodeCategorie(codeCategorie)
                .map(CategorieDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune Catégorie avec le CODE= " + codeCategorie +
                        " n'est trouvé dans la BDD", CodesErreurs.CATEGORIE_NOT_FOUND));
    }

    @Override
    public List<CategorieDto> recupererTout() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Votre ID est nulle");
            return;
        }

        categorieRepository.deleteById(id.longValue());
    }
}
