package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.MouvementStockDto;
import com.abdouljr.GestionDeStock.Services.MouvementStockService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/mouvementstock")
public class MouvementStockController {

    @Autowired
    public MouvementStockService mouvementStockService;


    // ============================================= CREATION D'UNE MOUVEMENT DE STOCK ==========================================
    @PostMapping("/creer")
    public MouvementStockDto creer(@RequestBody MouvementStockDto mouvementStockDto){
        return mouvementStockService.sauvegarder(mouvementStockDto);
    }


    // ============================================= RECUPERER UNE MOUVEMENT DE STOCK PAR SON ID ===================================
    @GetMapping("/{id}")
    public MouvementStockDto recupererParId(@PathVariable Integer id){
        return mouvementStockService.recupererParId(id);
    }



    // ============================================= RECUPER TOUS LES MOUVEMENTS DES STOCKS ========================================
    @GetMapping("/tout")
    public List<MouvementStockDto> recupererTout(){
        return mouvementStockService.recupererTout();
    }


    // ============================================= SUPPRIMER UN MOUVEMENT DE STOCK PAR SON ID ====================================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        mouvementStockService.supprimer(id);
    }

}
