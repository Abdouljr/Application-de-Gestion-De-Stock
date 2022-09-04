package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.UtilisateurDto;
import com.abdouljr.GestionDeStock.Services.UtilisateurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    public UtilisateurService utilisateurService;


    // ============================================= CREATION D'UN UTILISATEUR =========================================
    @PostMapping("/creer")
    public UtilisateurDto creer(@RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.sauvegarder(utilisateurDto);
    }


    // ============================================= RECUPERER UN UTILISATEUR PAR SON ID ===============================
    @GetMapping("/{id}")
    public UtilisateurDto recupererParId(@PathVariable Integer id){
        return utilisateurService.recupererParId(id);
    }


    // ============================================= RECUPER TOUT LES UTILISATEURS =====================================
    @GetMapping("/tout")
    public List<UtilisateurDto> recupererTout(){
        return utilisateurService.recupererTout();
    }


    // ============================================= SUPPRIMER UN UTILISATEUR PAR SON ID ===============================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        utilisateurService.supprimer(id);
    }


}


