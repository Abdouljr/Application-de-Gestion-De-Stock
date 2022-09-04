package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;
import com.abdouljr.GestionDeStock.Services.ArticleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@Data
public class ArticleController {
    @Autowired
    public ArticleService articleService;


    // ============================================= CREATION D'UN ARTICLE =============================================
    @PostMapping("/creer")
    public ArticleDto creer(@RequestBody ArticleDto articleDto){
        return articleService.sauvegarder(articleDto);
    }



    // ============================================= RECUPERER UN ARTICLE PAR SON ID====================================
    @GetMapping("/{id}")
    public ArticleDto recupererParId(@PathVariable Integer id){
        return articleService.recupererParId(id);
    }


    // =========    ==================================== RECUPERER UN ARTICLE PAR SON CODE==============================
    @GetMapping("/{codeArticle}")
    public ArticleDto recupererParCodeArticle(@PathVariable String codeArticle){
        return articleService.recupererParCodeArticle(codeArticle);
    }


    // =========    ==================================== RECUPERER TOUT LES ARTICLES ===================================
    @GetMapping("/tout")
    public List<ArticleDto> recupererTout(){
        return articleService.recupererTout();
    }


    // =========    ==================================== SUPPRIMER UN ARTICLE ==========================================
    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        articleService.supprimer(id);
    }
}
