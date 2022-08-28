package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Long> {
}
