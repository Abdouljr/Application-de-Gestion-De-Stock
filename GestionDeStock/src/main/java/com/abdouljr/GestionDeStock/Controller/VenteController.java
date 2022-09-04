package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.VenteDto;
import com.abdouljr.GestionDeStock.Services.VenteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/vente")
public class VenteController {

    @Autowired
    public VenteService venteService;

    // ============================================= CREATION D'UNE VENTE ==============================================
    @PostMapping("/creer")
    public VenteDto creer(@RequestBody VenteDto venteDto){
        return venteService.sauvegarder(venteDto);
    }


    // ============================================= RECUPERER UNE VENTE PAR SON ID ====================================
    @GetMapping("/{id}")
    public VenteDto recupererParId(@PathVariable Integer id){
        return venteService.recupererParId(id);
    }


    // ============================================= RECUPERER UNE VENTE PAR SON CODE ==================================
    @PostMapping("/{codeVente}")
    public VenteDto recupererParCodeVente(@PathVariable String codeVente){
        return venteService.recupererParCodeVente(codeVente);
    }


    // ============================================= RECUPER TOUTES LES VENTES =========================================
    @GetMapping("/tout")
    public List<VenteDto> recupererTout(){
        return venteService.recupererTout();
    }


    // ============================================= SUPPRIMER UNE VENTE PAR SON ID ====================================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        venteService.supprimer(id);
    }

}
