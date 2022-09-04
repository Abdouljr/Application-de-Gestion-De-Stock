package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto sauvegarder(EntrepriseDto entrepriseDto);
    EntrepriseDto recupererParId(Integer id);
    EntrepriseDto recupererParNom(String nom);
    List<EntrepriseDto> recupererTout();
    void supprimer(Integer id);
}
