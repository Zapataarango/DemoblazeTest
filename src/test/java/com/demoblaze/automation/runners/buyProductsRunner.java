package com.demoblaze.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buyProducts.feature",
        glue = "com.demoblaze.automation.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class buyProductsRunner {
}
