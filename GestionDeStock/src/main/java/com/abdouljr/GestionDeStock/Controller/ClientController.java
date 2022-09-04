package com.abdouljr.GestionDeStock.Controller;

import com.abdouljr.GestionDeStock.Dto.ClientDto;
import com.abdouljr.GestionDeStock.Services.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    public ClientService clientService;

    // ============================================= CREATION D'UN CLIENT ==============================================
    @PostMapping("/creer")
    public ClientDto creer(@RequestBody ClientDto clientDto){
        return clientService.sauvegarder(clientDto);
    }


    // ============================================= RECUPERER UNE CLIENT PAR SON ID ===================================
    @GetMapping("/{id}")
    public ClientDto recupererParId(@PathVariable Integer id){
        return clientService.recupererParId(id);
    }


    // ============================================= RECUPERER UN CLIENT PAR SON NUMERO ================================
    @PostMapping("/{numero}")
    public ClientDto recupererParNumero(@PathVariable String numero){
        return clientService.recupererParNumero(numero);
    }


    // ============================================= RECUPER TOUT LES CLIENTS ==========================================
    @GetMapping("/tout")
    public List<ClientDto> recupererTout(){
        return clientService.recupererTout();
    }


    // ============================================= SUPPRIMER UN CLIENT PAR SON ID ====================================
    @DeleteMapping("supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        clientService.supprimer(id);
    }
}
