package com.demoblaze.automation.tasks;

import com.demoblaze.automation.models.User;
import com.demoblaze.automation.userInterfaces.DemoBlazePage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demoblaze.automation.userInterfaces.DemoBlazePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class Login implements Task {
    private User user;

    public static Login onDemoblaze(User user) {
        return Tasks.instrumented(Login.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_LOGIN, isEnabled()),
                Click.on(BTN_LOGIN),
                WaitUntil.the(INPUT_USERNAME, isEnabled()),
                Enter.theValue(user.getName()).into(INPUT_USERNAME),
                Enter.theValue(user.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_CONFIRM_LOGIN)
        );
    }
}
