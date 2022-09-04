package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;
import com.abdouljr.GestionDeStock.Dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto sauvegarder(FournisseurDto fournisseurDto);
    FournisseurDto recupererParId(Integer id);
    FournisseurDto recupererParNumero(String numero);
    List<FournisseurDto> recupererTout();
    void supprimer(Integer id);
}
