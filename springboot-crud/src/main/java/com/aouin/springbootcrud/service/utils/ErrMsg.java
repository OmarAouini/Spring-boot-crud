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
    String U002 = "U002"; // ruolo sconosciuto
    String U003 = "U003"; // uno o più campi degli indirizzi non è valido
    String U004 = "U004"; // password invalida, caratteri richiesti mancanti
    String U005 = "U005"; // password vuota o nulla o minore di 8 caratteri

    //CHECKOUTS ERROR MESSAGES
    String C001 = "C001"; // carrello con id specificato non trovato
    //MISC
    String IT = "it";
    String EN = "en";
}
