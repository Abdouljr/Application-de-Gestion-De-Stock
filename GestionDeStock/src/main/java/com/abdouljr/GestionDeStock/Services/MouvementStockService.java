package com.abdouljr.GestionDeStock.Services;

import com.abdouljr.GestionDeStock.Dto.MouvementStockDto;
import java.util.List;

public interface MouvementStockService {

    MouvementStockDto sauvegarder(MouvementStockDto mouvementStockDto);
    MouvementStockDto recupererParId(Integer id);
    List<MouvementStockDto> recupererTout();
    void supprimer(Integer id);

}
