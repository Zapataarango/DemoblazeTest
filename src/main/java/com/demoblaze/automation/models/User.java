package com.demoblaze.automation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private String password;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;

}
