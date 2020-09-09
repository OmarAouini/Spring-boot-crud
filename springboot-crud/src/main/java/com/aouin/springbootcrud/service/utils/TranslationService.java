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
        return this.errorMap.get(msg).get(lang);
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

        return errors;
    }
}
