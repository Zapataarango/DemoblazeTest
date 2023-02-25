package com.demoblaze.automation.utils;


public class Splits {

    public static String[] products(String products) {
        return products.split(",");
    }

    public static int Quantityelements(String products) {
        return products.split(",").length;
    }
}
