package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Dto.EntrepriseDto;
import com.abdouljr.GestionDeStock.Modeles.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    Optional<Entreprise> findByNom(String nom);
}
