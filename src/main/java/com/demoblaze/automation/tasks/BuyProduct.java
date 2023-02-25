package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.Wait;
import com.demoblaze.automation.utils.Splits;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.*;

@AllArgsConstructor
public class BuyProduct implements Task {
    private String product;

    public static BuyProduct onDemoblaze(String product) {
        return Tasks.instrumented(BuyProduct.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember("LIST_PRODUCTS", product);
        for (int i = 0; i < Splits.products(product).length; i++) {
            actor.attemptsTo(
                    Wait.seconds(1),
                    Scroll.to(BTN_PRODUCTS.of(Splits.products(product)[i])),
                    Click.on(BTN_PRODUCTS.of(Splits.products(product)[i])),
                    Click.on(BTN_ADD_TO_CART),
                    Wait.seconds(2),
                    Click.on(LBL_HOME));
        }
    }

}

