package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.CategorieDto;

import java.util.List;

public interface CategorieService {

    CategorieDto sauvegarder(CategorieDto categorieDto);
    CategorieDto recupererParId(Integer id);

    CategorieDto recupererParCodeCategorie(String codeCategorie);

    List<CategorieDto> recupererTout();
    void supprimer(Integer id);
}
