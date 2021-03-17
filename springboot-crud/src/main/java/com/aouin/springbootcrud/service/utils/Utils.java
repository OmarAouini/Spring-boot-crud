package com.aouin.springbootcrud.service.utils;

public class Utils {

    public static boolean isNullOrEmptyString(String s) {
        if (s == null || s.isEmpty()) {
           return true;
        }
        return false;
    }
}
