package com.abdouljr.GestionDeStock.Validator;

import com.abdouljr.GestionDeStock.Dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {
        public List<String> validator(RolesDto dto) {
            List<String> erreurs = new ArrayList<>();

            if(dto == null || !StringUtils.hasLength(dto.getRole())){
                erreurs.add("Veillez renseigner le rôle de l'utilisateur");
            }
            return erreurs;
        }
}
