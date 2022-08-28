package com.abdouljr.GestionDeStock.Dto;

import com.abdouljr.GestionDeStock.Modeles.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


@Builder  // Va nous permettre d'exposer nos données
@Data
public class RolesDto {

    private Integer id;
    private String role;

    @JsonIgnore
    private UtilisateurDto utilisateur;

    public RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .role(roles.getRole())
                .build();
    }

    public Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRole(rolesDto.getRole());
        return roles;
    }
}
