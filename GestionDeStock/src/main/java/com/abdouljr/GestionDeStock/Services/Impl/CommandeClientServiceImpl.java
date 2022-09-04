package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Modeles.Article;
import com.abdouljr.GestionDeStock.Modeles.Client;
import com.abdouljr.GestionDeStock.Repository.ArticleRepository;
import com.abdouljr.GestionDeStock.Repository.ClientRepository;
import com.abdouljr.GestionDeStock.Repository.CommandeClientRepository;
import com.abdouljr.GestionDeStock.Services.CommandeClientService;
import com.abdouljr.GestionDeStock.Validator.CommandeClientValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {
    @Autowired
    public CommandeClientRepository commandeClientRepository;

    @Autowired
    public ClientRepository clientRepository;

    @Autowired
    public ArticleRepository articleRepository;

    @Override
    public CommandeClientDto sauvegarder(CommandeClientDto commandeClientDto) {
        List<String> erreurs = CommandeClientValidator.valider(commandeClientDto);
        if (!erreurs.isEmpty()){
            log.error("Cette commande client n'est pas valide");
            throw new ExceptionEntiteInvalide("Cette commande client n'est pas valide", CodesErreurs.COMMANDE_CLIENT_NOT_VALID, erreurs);
        }

        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId().longValue());
        if (client.isEmpty()){
            log.error("Cet client n'existe pas dans la BDD");
            throw new ExceptionEntiteNonTrouve("Cet client n'existe pas dans la BDD", CodesErreurs.CLIENT_NOT_FOUND);
        }

        List<String> articleErreurs = new ArrayList<>();
        // TO DO L'INPLEMENTATION N'EST PAS ENCORE FINI
        if (commandeClientDto.getLigneCommandeClients() != null){
            commandeClientDto.getLigneCommandeClients().forEach( ldc -> {
                if (ldc.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ldc.getArticle().getId().longValue());
                    if (article.isEmpty()){
                        articleErreurs.add("L'article avec l'ID: " + ldc.getArticle().getId() + " n'existe pas");
                    }
                }
            });
        }
        return CommandeClientDto.fromEntity(commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto)));
    }

    @Override
    public CommandeClientDto recupererParId(Integer id) {
        if (id == null){
            log.error("Commande client ID est null");
            return null;
        }
        return commandeClientRepository.findById(id.longValue())
                .map(CommandeClientDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune commande client avec cet ID= " + id + " n'est trouvée" +
                        " dans la BDD", CodesErreurs.COMMANDE_CLIENT_NOT_FOUND));
    }


    @Override
    public CommandeClientDto recupererParCodeClient(String codeClient) {
        return commandeClientRepository.findByCodeClient(codeClient)
                .map(CommandeClientDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucune commande client avec ce code client= " + codeClient + " n'est trouvée" +
                        " dans la BDD", CodesErreurs.COMMANDE_CLIENT_NOT_FOUND));
    }


    @Override
    public List<CommandeClientDto> recupererTout() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null){
            log.error("Commande client ID est null");
            return;
        }
        commandeClientRepository.deleteById(id.longValue());
    }
}
