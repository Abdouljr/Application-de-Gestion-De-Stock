package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Repository.ArticleRepository;
import com.abdouljr.GestionDeStock.Services.ArticleService;
import com.abdouljr.GestionDeStock.Validator.ArticleValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j      // ==> POUR LE LOGIN
@Data
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> erreurs = ArticleValidator.valider(articleDto);
        if (!erreurs.isEmpty()){
            log.error("Article n'est pas valide ()", articleDto);
            throw new ExceptionEntiteInvalide("Article n'est pas valide", CodesErreurs.ARTICLE_NOT_VALID, erreurs);
        }
        return null;
    }

    @Override
    public ArticleDto findById(Integer id) {
        return null;
    }

    @Override
    public ArticleDto findByIdCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }
}
