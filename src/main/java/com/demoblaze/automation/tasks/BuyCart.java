package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.CountAllProducts;
import com.demoblaze.automation.interactions.Wait;
import com.demoblaze.automation.models.User;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.*;

@AllArgsConstructor
public class BuyCart implements Task {
    private User user;

    public static BuyCart onDemoblaze(User user) {
        return Tasks.instrumented(BuyCart.class, user);
    }

    @Step("{0} buys the cart.")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LBL_CART),
                Wait.seconds(2),
                CountAllProducts.ofTheList(),
                Click.on(BTN_PLACE_ORDER),
                Wait.seconds(2),
                Enter.theValue(user.getName()).into(INPUT_NAME),
                Enter.theValue(user.getCountry()).into(INPUT_COUNTRY),
                Enter.theValue(user.getCity()).into(INPUT_CITY),
                Enter.theValue(user.getCreditCard()).into(INPUT_CREDIT_CARD),
                Enter.theValue(user.getMonth()).into(INPUT_MONTH),
                Enter.theValue(user.getYear()).into(INPUT_YEAR),
               Click.on(BTN_PURCHASE)
        );
    }
}
