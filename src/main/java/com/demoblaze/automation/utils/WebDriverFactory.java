package com.demoblaze.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver goToWeb(String url) {
        WebDriver driver = getDriver();
        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver getChromeDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments(
                "--incognito",
                "--disable-infobars",
                "enable-automation",
                "--disable-browser-side-navigation");
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return WebDriverManager.chromedriver().capabilities(chromeOptions).create();

    }

    private static WebDriver getDriver() {
        return (Constantes.DEFAULT_BROWSER.equals(Constantes.EDGE)) ? getEdgeDriver() : getChromeDriver();
    }

    private static WebDriver getEdgeDriver() {

        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return WebDriverManager.edgedriver().capabilities(options).create();
    }
}