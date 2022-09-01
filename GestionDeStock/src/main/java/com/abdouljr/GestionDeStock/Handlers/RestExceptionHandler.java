package com.abdouljr.GestionDeStock.Handlers;

import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteInvalide;
import com.abdouljr.GestionDeStock.Exception.ExceptionEntiteNonTrouve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

            // ==> ICI ON VA CREER UNE EXCEPTION GLOBALE <==

@RestControllerAdvice       // ==> AVEC CETTE ANNOTATION ON PAS BESOIN DE METTRE A CHAQUE FOIS REQUESTBODY
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // on retourne des reponses entités des erreurs dto avec les paramettre exception et la requette en question
    //C'EST CETTE ANNOTATION QUI PERMET DE CAPTER DIRECTEMENT UNE ERREUR LORSQUE UNE EXCEPTION EST LEVER AU NIVEAU
    //DE CETTE CLASSE(EENT)  GRACE AU RESCONTROLLERADVICE ET LE PASSER A CETTE METHODE
    @ExceptionHandler(ExceptionEntiteNonTrouve.class)
    public ResponseEntity<ErreurDto> handlerException(ExceptionEntiteNonTrouve exception, WebRequest requeteWeb){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;          // ==> ici on creer une erreur code 404
        //ici on va changer les valeurs des données notre dto erreur avec les données de EENT et Httpstatus
         final ErreurDto erreurDto = ErreurDto.builder()  // ==> ici je l'ai mis en final au debut
                .codesErreurs(exception.getCodesErreurs())
                .message(exception.getMessage())
                .httpcode(notFound.value())
                .build();
        return new ResponseEntity<>(erreurDto, notFound);
    }

    @ExceptionHandler(ExceptionEntiteInvalide.class)
    public ResponseEntity<ErreurDto> handlerException(ExceptionEntiteInvalide exception, WebRequest requetteWeb){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErreurDto erreurDto = ErreurDto.builder()  // ==> ici je l'ai mis en final au debut
                .codesErreurs(exception.getCodesErreurs())
                .message(exception.getMessage())
                .httpcode(badRequest.value())
                .erreurs(exception.getErreurs())
                .build();
        return new ResponseEntity<>(erreurDto, badRequest);
    }
}
