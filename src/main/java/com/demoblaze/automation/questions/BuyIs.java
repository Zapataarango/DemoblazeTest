package com.demoblaze.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.LBL_PRICE;


public class BuyIs implements Question<Boolean> {
    public BuyIs done() {
        return new BuyIs();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String totalCost = actor.recall("TOTAL_VALUE");
        System.out.println(LBL_PRICE);
        return true;
    }
}
