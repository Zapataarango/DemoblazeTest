package com.demoblaze.automation.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Constantes {
    public static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String DEFAULT_BROWSER = CONF.getProperty("config.browser.default");
    public static final String EDGE = "Edge";
    public static final String CHROME = "Chrome";
    public static final String URL = "https://www.demoblaze.com/index.html";
    public static final String PURCHASE_CONFIRMATION = "Thank you for your purchase!";
}
