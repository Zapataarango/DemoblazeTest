package com.demoblaze.automation.questions;

import com.demoblaze.automation.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.BTN_OK;
import static com.demoblaze.automation.userInterfaces.DemoBlazePage.LBL_CONFIRMATION_PURCHASE;
import static com.demoblaze.automation.utils.Constantes.PURCHASE_CONFIRMATION;


public class BuyIs implements Question<Boolean> {
    public static BuyIs done() {
        return new BuyIs();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(PURCHASE_CONFIRMATION).isEqualTo(LBL_CONFIRMATION_PURCHASE.resolveFor(actor).getText())
        );

        actor.attemptsTo(
                Click.on(BTN_OK)
        );

        return true;
    }
}
