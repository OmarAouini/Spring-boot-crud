package com.aouin.springbootcrud.service.utils;

public interface ErrMsg {

    // ARTICLES ERROR MESSAGES
    String A001 = "A001"; // non trovato
    String A002 = "A002"; // Id dell'articolo non trovato
    String A003 = "A003"; // categoria sconosciuta
    String A004 = "A004"; // prezzo minore di zero
    String A005 = "A005"; // campo nome obbligatorio
    String A006 = "A006"; // campo categorie obbligatorio
    String A007 = "A007"; // stock quantity negativo
    String A008 = "A008"; // shipping details con valori negativi
    String A009 = "A009"; // manufacture details con valori negativi

    //USER ERROR MESSAGES
    String U001 = "U001"; // Id utente non trovato

    //CHECKOUTS ERROR MESSAGES
    String C001 = "C001";
    //MISC
    String IT = "it";
    String EN = "en";
}
