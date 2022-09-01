package com.abdouljr.GestionDeStock.Exception;

import lombok.Getter;

import java.util.List;

// CETTE EXCEPTION C'EST QUAND
@Getter
public class ExceptionEntiteInvalide extends RuntimeException{

    List<String> erreurs;
    private CodesErreurs codesErreurs;
    // retourne le message
    public ExceptionEntiteInvalide(String message){
        super(message);
    }

    // retourne le message et la cause
    public ExceptionEntiteInvalide(String message,Throwable cause){
        super(message,cause);
    }

    // retourne le message, la cause et le code d'erreur
    public ExceptionEntiteInvalide(String message, Throwable cause, CodesErreurs codesErreur){
        super(message, cause);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur
    public ExceptionEntiteInvalide(String message, CodesErreurs codesErreur){
        super(message);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur et  la liste des erreurs
    public ExceptionEntiteInvalide(String message, CodesErreurs codesErreur, List<String> erreurs){
        super(message);
        this.codesErreurs = codesErreur;
        this.erreurs = erreurs;
    }

}
