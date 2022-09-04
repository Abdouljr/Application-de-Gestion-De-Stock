package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.CategorieDto;
import com.abdouljr.GestionDeStock.Services.CategorieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/Categorie")
public class CategorieController {

    @Autowired
    public CategorieService categorieService;


    // ============================================= CREATION D'UNE CATEGORIE ==========================================
    @PostMapping("/creer")
    public CategorieDto creer(@RequestBody CategorieDto categorieDto){
        return categorieService.sauvegarder(categorieDto);
    }


 // ============================================= RECUPERER UNE CATEGORIE PAR SON ID ===================================
    @GetMapping("/{id}")
    public CategorieDto recupererParId(@PathVariable Integer id){
        return categorieService.recupererParId(id);
    }


    // ============================================= RECUPERER UNE CATEGORIE PAR SON CODE ==============================
    @PostMapping("/{codeCategorie}")
    public CategorieDto recupererParCodeCategorie(@PathVariable String codeCategorie){
        return categorieService.recupererParCodeCategorie(codeCategorie);
    }


 // ============================================= RECUPERER TOUTES LES CATEGORIES ======================================
    @GetMapping("/tout")
    public List<CategorieDto> recupererTout(){
        return categorieService.recupererTout();
    }


// ============================================= SUPPRIMER UNE CATEGORIE PAR SON ID ====================================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
       categorieService.supprimer(id);
    }
}
