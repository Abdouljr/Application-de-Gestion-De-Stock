package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;
import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;
import com.abdouljr.GestionDeStock.Services.ArticleService;
import com.abdouljr.GestionDeStock.Services.EntrepriseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    public EntrepriseService entrepriseService;


    // ============================================= CREATION D'UNE ENTREPRISE =========================================
    @PostMapping("/creer")
    public EntrepriseDto creer(@RequestBody EntrepriseDto entrepriseDto){
        return entrepriseService.sauvegarder(entrepriseDto);
    }



    // ============================================= RECUPERER UNE ENTREPRISE PAR SON ID================================
    @GetMapping("/{id}")
    public EntrepriseDto recupererParId(@PathVariable Integer id){
        return entrepriseService.recupererParId(id);
    }


    // =========    ==================================== RECUPERER UNE ENTREPRISE PAR SON NOM===========================
    @GetMapping("/{nom}")
    public EntrepriseDto recupererParNom(@PathVariable String nom){
        return entrepriseService.recupererParNom(nom);
    }


    // =========    ==================================== RECUPERER TOUTES LES ENTREPRISES ==============================
    @GetMapping("/tout")
    public List<EntrepriseDto> recupererTout(){
        return entrepriseService.recupererTout();
    }


    // ================================================= SUPPRIMER UNE ENTREPRISE PAR SON ID ===========================
    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        entrepriseService.supprimer(id);
    }

}
