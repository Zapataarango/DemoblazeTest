package com.demoblaze.automation.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoBlazePage {

    public static final Target BTN_LOGIN = Target.the("Button to login").
            locatedBy("//a[@id='login2']");

    public static final Target INPUT_USERNAME = Target.the("username input").
            locatedBy("//input[@id='loginusername']");

    public static final Target INPUT_PASSWORD = Target.the("password input").
            locatedBy("//input[@id='loginpassword']");

    public static final Target BTN_CONFIRM_LOGIN = Target.the("Button to login").
            locatedBy("//button[contains(text(),'Log in')]");
    public static final Target BTN_PRODUCTS = Target.the("Button to select products").
            locatedBy("//a[contains(text(),'{0}')]");

    public static final Target BTN_ADD_TO_CART = Target.the("Button to add to cart").
            locatedBy("//a[text()='Add to cart']");

    public static final Target LBL_HOME = Target.the("Button to go home").
            locatedBy("//a[text()='Home ']");

    public static final Target LBL_CART = Target.the("Button to go to cart").
            locatedBy("//a[text()='Cart']");

    public static final Target BTN_PLACE_ORDER = Target.the("Button to place the order").
            locatedBy("//button[text()='Place Order']");

    public static final Target INPUT_NAME = Target.the("name input in cart").
            locatedBy("//*[@id='name']");

    public static final Target INPUT_COUNTRY = Target.the("Country input in cart").
            locatedBy("//*[@id='country']");

    public static final Target INPUT_CITY = Target.the("City input in cart").
            locatedBy("//*[@id='city']");

    public static final Target INPUT_CREDIT_CARD = Target.the("Credit card input in cart").
            locatedBy("//*[@id='card']");

    public static final Target INPUT_MONTH = Target.the("expiration month of card input in cart").
            locatedBy("//*[@id='month']");

    public static final Target INPUT_YEAR = Target.the("expiration year of card input in cart").
            locatedBy("//*[@id='year']");

    public static final Target BTN_PURCHASE = Target.the("Purchase button").
            locatedBy("//button[text()='Purchase']");

    public static final Target LBL_CONFIRMATION_PURCHASE = Target.the("Purchase confirmation label").
            locatedBy("//h2[text()='Thank you for your purchase!']");

    public static final Target LBL_VALUE_PRODUCT = Target.the("Purchase confirmation label").
            locatedBy("(//td[contains(text(),'{0}')]/following-sibling::td)[1]");

    public static final Target BTN_OK = Target.the("'OK' button in confirmation message").
            locatedBy("//button[text()='OK']");

    public static final Target LBL_PRICE = Target.the("Label of total cost of products.")
            .locatedBy("id:totalp");
}
