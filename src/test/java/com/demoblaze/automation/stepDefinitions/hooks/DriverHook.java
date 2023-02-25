package com.demoblaze.automation.stepDefinitions.hooks;

import com.demoblaze.automation.utils.WebDriverFactory;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;


public class DriverHook {
    @Before
    public static void setup() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(WebDriverFactory.goToWeb("https://www.demoblaze.com/index.html"))));
        OnStage.theActorCalled("Automation");
    }
}
