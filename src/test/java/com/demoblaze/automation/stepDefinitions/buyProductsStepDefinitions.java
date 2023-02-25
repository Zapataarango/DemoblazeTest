package com.demoblaze.automation.stepDefinitions;

import com.demoblaze.automation.tasks.BuyCart;
import com.demoblaze.automation.tasks.BuyProduct;
import com.demoblaze.automation.tasks.Login;
import com.demoblaze.automation.utils.ReadFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;


public class buyProductsStepDefinitions {

    @Given("{string} logs with credentials")
    public void logsWithCredentials(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.onDemoblaze(ReadFiles.readUser(user)));
    }

    @When("buys a list {string}")
    public void buysAList(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuyProduct.onDemoblaze(ReadFiles.readProducts(product)));
    }

    @When("{string} shoulds see the product in the cart")
    public void shouldsSeeTheProductInTheCart(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuyCart.onDemoblaze(ReadFiles.readUser(user)));
    }

}
