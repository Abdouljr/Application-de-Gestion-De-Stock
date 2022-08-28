package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
