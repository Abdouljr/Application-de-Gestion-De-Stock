package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.ClientDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Repository.ClientRepository;
import com.abdouljr.GestionDeStock.Services.ClientService;
import com.abdouljr.GestionDeStock.Validator.ClientValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    public ClientRepository clientRepository;

    @Override
    public ClientDto sauvegarder(ClientDto clientDto) {
        List<String> erreurs = ClientValidator.valider(clientDto);
        if (clientDto == null){
            log.error("Client n'est pas valide");
            throw new ExceptionEntiteInvalide("Client n'est pas valide", CodesErreurs.CLIENT_NOT_INVALID, erreurs);

        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto recupererParId(Integer id) {
        if (id == null){
            log.error("Cet client ID est nulle");
            return null;
        }
        return clientRepository.findById(id.longValue())
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun client avec l'ID= " + id + " n'est trouvé" +
                        "dans la BDD", CodesErreurs.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto recupererParNumero(String numero) {
        if (numero == null){
            log.error("Ce Numéro est nul");
            return null;
        }
        return clientRepository.findByNumero(numero)
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun client avec Numéro= " + numero + " n'est" +
                        "trouvé dans la BDD", CodesErreurs.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> recupererTout() {
        return clientRepository.findAll().stream()
                .map(ClientDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Cet Id est null");
        return;
        }
        clientRepository.deleteById(id.longValue());
    }
}
