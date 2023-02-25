package com.demoblaze.automation.interactions;

import com.demoblaze.automation.utils.Splits;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.LBL_PRICE;
import static com.demoblaze.automation.userInterfaces.DemoBlazePage.LBL_VALUE_PRODUCT;


public class CountAllProducts implements Interaction {

    public static CountAllProducts ofTheList() {
        return Tasks.instrumented(CountAllProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int totalProductsCost = 0;
        String listProducts = actor.recall("LIST_PRODUCTS");
        for (int i = 0; i < Splits.products(listProducts).length; i++) {
            totalProductsCost += Integer.parseInt(LBL_VALUE_PRODUCT.of(Splits.products(listProducts)[i]).
                    resolveFor(actor).getText());
        }
        actor.attemptsTo(
                Ensure.that(Integer.toString(totalProductsCost)).isEqualTo(LBL_PRICE.resolveFor(actor).getText())
        );
    }
}
