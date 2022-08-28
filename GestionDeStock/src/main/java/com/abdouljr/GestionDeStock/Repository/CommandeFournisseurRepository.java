package com.abdouljr.GestionDeStock.Repository;

import com.abdouljr.GestionDeStock.Modeles.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {
}
