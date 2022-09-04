package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.ClientDto;
import com.abdouljr.GestionDeStock.Dto.FournisseurDto;
import com.abdouljr.GestionDeStock.Services.FournisseurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    public FournisseurService fournisseurService;


    // ============================================= CREATION D'UN FOURNISSEUR =========================================
    @PostMapping("/creer")
    public FournisseurDto creer(@RequestBody FournisseurDto fournisseurDto){
        return fournisseurService.sauvegarder(fournisseurDto);
    }


    // ============================================= RECUPERER UNE FOURNISSEUR PAR SON ID ==============================
    @GetMapping("/{id}")
    public FournisseurDto recupererParId(@PathVariable Integer id){
        return fournisseurService.recupererParId(id);
    }


    // ============================================= RECUPERER UN FOURNISSEUR PAR SON NUMERO ===========================
    @PostMapping("/{numero}")
    public FournisseurDto recupererParNumero(@PathVariable String numero){
        return fournisseurService.recupererParNumero(numero);
    }


    // ============================================= RECUPER TOUT LES FOURNISSEURS =====================================
    @GetMapping("/tout")
    public List<FournisseurDto> recupererTout(){
        return fournisseurService.recupererTout();
    }


    // ============================================= SUPPRIMER UN FOURNISSEUR PAR SON ID ===============================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        fournisseurService.supprimer(id);
    }

}
