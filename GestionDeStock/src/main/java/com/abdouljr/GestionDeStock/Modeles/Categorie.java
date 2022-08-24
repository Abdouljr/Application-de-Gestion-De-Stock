package com.abdouljr.GestionDeStock.Modeles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Categorie extends EntiteAbstraite{

    private String codeCategorie;
    private String designation;

    @OneToMany(mappedBy = "categorie")
    List<Article> articles;
}
