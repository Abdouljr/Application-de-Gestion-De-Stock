package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto sauvegarder(UtilisateurDto utilisateurDto);
    UtilisateurDto recupererParId(Integer id);
    List<UtilisateurDto> recupererTout();
    void supprimer(Integer id);
}
