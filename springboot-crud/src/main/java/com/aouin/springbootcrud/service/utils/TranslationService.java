package com.aouin.springbootcrud.service.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TranslationService {

    private Map<String, Map<String, String>> errorMap;

    public TranslationService() {
        this.errorMap = buildErrorMap();
    }

    public String getMsg(String msg, String lang) {
        if ( (msg != null && !msg.isEmpty()) && (lang != null && !lang.isEmpty()))
            return this.errorMap.get(msg).get(lang);
        else
            return msg;
    }

    private Map<String, Map<String, String>> buildErrorMap() {

        Map<String, Map<String, String>> errors = new HashMap<>();

        //A001
        Map<String, String> message1 = new HashMap<>();
        message1.put(ErrMsg.IT, "non trovato");
        message1.put(ErrMsg.EN, "not found");
        errors.put(ErrMsg.A001, message1);

        //A002
        Map<String, String> message2 = new HashMap<>();
        message2.put(ErrMsg.IT, "Id dell'articolo non trovato");
        message2.put(ErrMsg.EN, "article Id not found");
        errors.put(ErrMsg.A002, message2);

        //A003
        Map<String, String> message3 = new HashMap<>();
        message3.put(ErrMsg.IT, "categoria sconosciuta");
        message3.put(ErrMsg.EN, "invalid category");
        errors.put(ErrMsg.A003, message3);

        //U001
        Map<String, String> message4 = new HashMap<>();
        message4.put(ErrMsg.IT, "Id utente non trovato");
        message4.put(ErrMsg.EN, "user Id not found");
        errors.put(ErrMsg.U001, message4);

        //A004
        Map<String, String> message5 = new HashMap<>();
        message5.put(ErrMsg.IT, "prezzo minore di zero");
        message5.put(ErrMsg.EN, "price is negative number");
        errors.put(ErrMsg.A004, message5);

        //A005
        Map<String, String> message6 = new HashMap<>();
        message6.put(ErrMsg.IT, "campo nome obbligatorio");
        message6.put(ErrMsg.EN, "name field is mandatory");
        errors.put(ErrMsg.A005, message6);

        //A006
        Map<String, String> message7 = new HashMap<>();
        message7.put(ErrMsg.IT, "categoria obbligatoria");
        message7.put(ErrMsg.EN, "category field is mandatory");
        errors.put(ErrMsg.A006, message7);


        //C001
        Map<String, String> message8 = new HashMap<>();
        message8.put(ErrMsg.IT, "carrello non trovato");
        message8.put(ErrMsg.EN, "checkout not found");
        errors.put(ErrMsg.C001, message8);

        //A007
        Map<String, String> message9 = new HashMap<>();
        message9.put(ErrMsg.IT, "quantità stock non valida");
        message9.put(ErrMsg.EN, "invalid stock quantity");
        errors.put(ErrMsg.A007, message9);

        //A008
        Map<String, String> message10 = new HashMap<>();
        message10.put(ErrMsg.IT, "dettagli spedizione con valori non validi");
        message10.put(ErrMsg.EN, "invalid shipping details values");
        errors.put(ErrMsg.A008, message10);

        //A009
        Map<String, String> message11 = new HashMap<>();
        message11.put(ErrMsg.IT, "dettagli produttore con valori non validi");
        message11.put(ErrMsg.EN, "invalid manufacture details values");
        errors.put(ErrMsg.A009, message11);

        //U002
        Map<String, String> message12 = new HashMap<>();
        message12.put(ErrMsg.IT, "ruolo sconosciuto");
        message12.put(ErrMsg.EN, "unknown role");
        errors.put(ErrMsg.U002, message12);

        //U003
        Map<String, String> message13 = new HashMap<>();
        message13.put(ErrMsg.IT, " uno o più campi degli indirizzi non è valido");
        message13.put(ErrMsg.EN, "one or more addresses field is not valid");
        errors.put(ErrMsg.U003, message13);

        //U004
        Map<String, String> message14 = new HashMap<>();
        message14.put(ErrMsg.IT, " password invalida, caratteri richiesti mancanti");
        message14.put(ErrMsg.EN, "invalid password,  one or more special characters missing");
        errors.put(ErrMsg.U004, message14);

        //U005
        Map<String, String> message15 = new HashMap<>();
        message15.put(ErrMsg.IT, "password vuota o nulla o minore di 8 caratteri");
        message15.put(ErrMsg.EN, "empty password and/or length is less than 8");
        errors.put(ErrMsg.U005, message15);


        //C001
        Map<String, String> message16 = new HashMap<>();
        message16.put(ErrMsg.IT, "carrello con id specificato non trovato");
        message16.put(ErrMsg.EN, "cart not found with the specified id");
        errors.put(ErrMsg.C001, message16);
        return errors;
    }
}
