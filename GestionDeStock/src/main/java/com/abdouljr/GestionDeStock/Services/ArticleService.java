package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto sauvegarder(ArticleDto articleDto);
    ArticleDto recupererParId(Integer id);
    ArticleDto recupererParCodeArticle(String codeArticle);
    List<ArticleDto> recupererTout();
    void supprimer(Integer id);
}
