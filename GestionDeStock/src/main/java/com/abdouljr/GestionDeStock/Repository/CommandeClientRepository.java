package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.Categorie;
import com.abdouljr.GestionDeStock.Modeles.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {

    Optional<CommandeClient> findByCodeClient(String codeClient);

}
