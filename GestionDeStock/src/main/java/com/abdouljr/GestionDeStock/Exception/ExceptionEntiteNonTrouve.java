package com.abdouljr.GestionDeStock.Exception;

public class ExceptionEntiteNonTrouve extends RuntimeException{

    private CodesErreurs codesErreurs;

    // retourne le message
    ExceptionEntiteNonTrouve(String message){
        super(message);
    }

    // retourne le message et la cause
    ExceptionEntiteNonTrouve(String message,Throwable cause){
        super(message,cause);
    }

    // retourne le message, la cause et le code d'erreur
    ExceptionEntiteNonTrouve(String message, Throwable cause, CodesErreurs codesErreur){
        super(message, cause);
        this.codesErreurs = codesErreur;
    }

    // retourne le message et le code d'erreur
    ExceptionEntiteNonTrouve(String message, CodesErreurs codesErreur){
        super(message);
        this.codesErreurs = codesErreur;
    }
}
