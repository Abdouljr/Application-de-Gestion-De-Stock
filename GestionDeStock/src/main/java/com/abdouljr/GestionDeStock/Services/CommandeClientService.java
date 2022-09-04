package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto sauvegarder(CommandeClientDto commandeClientDto);
    CommandeClientDto recupererParId(Integer id);

    CommandeClientDto recupererParCodeClient(String codeClient);

    List<CommandeClientDto> recupererTout();
    void supprimer(Integer id);
}
