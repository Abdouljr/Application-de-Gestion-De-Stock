package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto sauvegarder(ClientDto clientDto);
    ClientDto recupererParId(Integer id);
    ClientDto recupererParNumero(String numero);
    List<ClientDto> recupererTout();
    void supprimer(Integer id);
}
