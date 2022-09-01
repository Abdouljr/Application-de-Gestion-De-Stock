package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByIdCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    String delete(Integer id);
}
