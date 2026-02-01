package com.example;

import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.log(java.util.logging.Level.INFO, "Result: {0}", calc.calculate(10, 5, "add-again"));
        }
        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin"); // NEW dangerous call
    }

}
