package com.abdouljr.GestionDeStock.Exception;

import java.util.List;

public class ExceptionEntiteInvalide extends RuntimeException{

    List<String> erreurs;
    private CodesErreurs codesErreurs;
    // retourne le message
    ExceptionEntiteInvalide(String message){
        super(message);
    }

    // retourne le message et la cause
    ExceptionEntiteInvalide(String message,Throwable cause){
        super(message,cause);
    }

    // retourne le message, la cause et le code d'erreur
    ExceptionEntiteInvalide(String message, Throwable cause, CodesErreurs codesErreur){
        super(message, cause);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur
    ExceptionEntiteInvalide(String message, CodesErreurs codesErreur){
        super(message);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur et  la liste des erreurs
    ExceptionEntiteInvalide(String message, CodesErreurs codesErreur, List<String> erreurs){
        super(message);
        this.codesErreurs = codesErreur;
        this.erreurs = erreurs;
    }

}
