package com.abdouljr.GestionDeStock.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass   // Pour le mapper comme un super classe
@EntityListeners(AuditingEntityListener.class)  // Ecoute pour qu'à chaque création ou modification,
// il va assigné de valeur à ces attributs
public class EntiteAbstraite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(nullable = false)
    @JsonIgnore
    private Instant dateCreation;       // La date de création

    @LastModifiedDate
    @Column(nullable = false)
    @JsonIgnore
    private Instant dateDerniereModification;        // La date de dernière modification
}
