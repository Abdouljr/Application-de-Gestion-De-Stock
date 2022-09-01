package com.abdouljr.GestionDeStock.Handlers;

import com.abdouljr.GestionDeStock.Exception.CodesErreurs;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ErreurDto {

    private Integer httpcode;
    private CodesErreurs codesErreurs;
    private String message;
    private List<String> erreurs = new ArrayList<>();
}
