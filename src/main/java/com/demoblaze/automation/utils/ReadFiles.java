package com.demoblaze.automation.utils;

import com.demoblaze.automation.models.User;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFiles {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFiles.class);
    private static final EnvironmentVariables VARIABLES = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String CONFIG_PRODUCTS = "products.";

    private static final String CONFIG_USERS = "users.";

    public static String readProducts(String products) {
        return VARIABLES.getProperty(
                CONFIG_PRODUCTS + products + ".listproducts"
        );
    }

    public static User readUser(String user) {
        return new User(
                VARIABLES.getProperty(CONFIG_USERS + user + ".name"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".password"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".country"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".city"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".creditCard"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".month"),
                VARIABLES.getProperty(CONFIG_USERS + user + ".year")
        );
    }
}
