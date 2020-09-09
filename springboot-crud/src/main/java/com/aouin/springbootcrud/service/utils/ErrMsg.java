package com.aouin.springbootcrud.service.utils;

public interface ErrMsg {

    // ARTICLES ERROR MESSAGES
    String A001 = "A001"; // non trovato
    String A002 = "A002"; // Id dell'articolo non trovato
    String A003 = "A003"; // categoria sconosciuta
    String A004 = "A004"; // prezzo minore di zero
    String A005 = "A005"; // campo nome obbligatorio

    //USER ERROR MESSAGES
    String U001 = "U001"; // Id utente non trovato

    //MISC
    String IT = "it";
    String EN = "en";
}
