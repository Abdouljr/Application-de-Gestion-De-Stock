package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.VenteDto;

import java.util.List;

public interface VenteService {

    VenteDto sauvegarder(VenteDto venteDto);
    VenteDto recupererParId(Integer id);

    VenteDto recupererParCodeVente(String codeVente);

    List<VenteDto> recupererTout();
    void supprimer(Integer id);
}
