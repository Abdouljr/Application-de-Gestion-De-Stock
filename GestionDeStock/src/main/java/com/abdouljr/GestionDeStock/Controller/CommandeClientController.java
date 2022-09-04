package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.CategorieDto;
import com.abdouljr.GestionDeStock.Dto.CommandeClientDto;
import com.abdouljr.GestionDeStock.Services.CommandeClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/commandeclient")
public class CommandeClientController {

    @Autowired
    public CommandeClientService commandeClientService;

    // ============================================= CREATION D'UNE COMMANDE CLIENT ====================================
    @PostMapping("/creer")
    public CommandeClientDto creer(@RequestBody CommandeClientDto commandeClientDto){
        return commandeClientService.sauvegarder(commandeClientDto);
    }


    // ============================================= RECUPERER UNE COMMANDE CLIENT PAR SON ID ==========================
    @GetMapping("/{id}")
    public CommandeClientDto recupererParId(@PathVariable Integer id){
        return commandeClientService.recupererParId(id);
    }


    // ============================================= RECUPERER UNE COMMANDE CLIENT PAR SON CODE ========================
    @PostMapping("/{codeClient}")
    public CommandeClientDto recupererParCodeClient(@PathVariable String codeClient){
        return commandeClientService.recupererParCodeClient(codeClient);
    }


    // ============================================= RECUPERER TOUTES LES COMMANDES CLIENTS ============================
    @GetMapping("/tout")
    public List<CommandeClientDto> recupererTout(){
        return commandeClientService.recupererTout();
    }


    // ============================================= SUPPRIMER UNE COMMANDE CLIENT PAR SON ID ==========================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        commandeClientService.supprimer(id);
    }

}
