package com.abdouljr.GestionDeStock.Exception;

// CETTE EXCEPTION C'EST QUAND

import lombok.Getter;

@Getter
public class ExceptionEntiteNonTrouve extends RuntimeException{

    private CodesErreurs codesErreurs;

    // retourne le message
    public ExceptionEntiteNonTrouve(String message){
        super(message);
    }

    // retourne le message et la cause
    public ExceptionEntiteNonTrouve(String message,Throwable cause){
        super(message,cause);
    }

    // retourne le message, la cause et le code d'erreur
    public ExceptionEntiteNonTrouve(String message, Throwable cause, CodesErreurs codesErreur){
        super(message, cause);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur
    public ExceptionEntiteNonTrouve(String message, CodesErreurs codesErreur){
        super(message);
        this.codesErreurs = codesErreur;
    }
}
