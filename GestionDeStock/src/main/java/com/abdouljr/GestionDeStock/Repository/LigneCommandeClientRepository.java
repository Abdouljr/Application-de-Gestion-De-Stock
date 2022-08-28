package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Long> {
}
