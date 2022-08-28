package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
