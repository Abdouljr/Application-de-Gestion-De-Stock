package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.Client;
import com.abdouljr.GestionDeStock.Modeles.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Long> {
    Optional<Vente> findByCodeVente(String codeVente);

}
