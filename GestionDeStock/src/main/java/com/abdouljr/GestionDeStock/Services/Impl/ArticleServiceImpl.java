package com.abdouljr.GestionDeStock.Services.Impl;

import com.abdouljr.GestionDeStock.Dto.ArticleDto;
import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import com.abdouljr.GestionDeStock.Modeles.Article;
import com.abdouljr.GestionDeStock.Repository.ArticleRepository;
import com.abdouljr.GestionDeStock.Services.ArticleService;
import com.abdouljr.GestionDeStock.Validator.ArticleValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j      // ==> POUR LE LOGIN
@Data
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleRepository articleRepository;

    @Override
    public ArticleDto sauvegarder(ArticleDto articleDto) {
        // creer une liste des erreurs à partir de la methode valider
        List<String> erreurs = ArticleValidator.valider(articleDto);
        if (!erreurs.isEmpty()){
            log.error("Article n'est pas valide ()");  //, articleDto
            throw new ExceptionEntiteInvalide("Article n'est pas valide", CodesErreurs.ARTICLE_NOT_VALID, erreurs);
        }
        Article articleSave = articleRepository.save(ArticleDto.toEntity(articleDto));
        return ArticleDto.fromEntity(articleSave);
        // ON PEUT FAIRE AUSSI COMME ça (
       //  ==> return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto recupererParId(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return  null;
        }

        // +++++++++++++++++++++++++ ON PEUT FAIRE CECI  +++++++++++++++++++++++++++++++++++
        //Optional<Article> article = articleRepository.findById(id.longValue());
        //ArticleDto dto = ArticleDto.fromEntity(article.get());     Optional.of(dto).orElseThrow(()
        // +++++++++++++++++++++++++ MAIS JE PREFERE CA  +++++++++++++++++++++++++++++++++++
        return articleRepository.findById(id.longValue())
                .map(ArticleDto ::fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun Article" +
                " avec L'ID= " + id + " n'est trouvé dans la BDD", CodesErreurs.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto recupererParCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Article Code is null");
            return null;
        }//Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);   Optional.of(ArticleDto.fromEntity(article.get()))
        return articleRepository.findByCodeArticle(codeArticle)
                .map(ArticleDto :: fromEntity)
                .orElseThrow(() -> new ExceptionEntiteNonTrouve("Aucun " +
                " Article avec cet CODE= " + "n'est trouvé dans la BDD", CodesErreurs.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> recupererTout() {
        return articleRepository.findAll().stream()
                .map(ArticleDto ::fromEntity)       // :: c'est qu'on appelle method reference
                .collect(Collectors.toList());
    }

    @Override
    public void supprimer(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        articleRepository.deleteById(id.longValue());
    }
}
