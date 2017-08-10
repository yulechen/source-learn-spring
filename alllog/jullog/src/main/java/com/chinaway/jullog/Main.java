package com.chinaway.jullog;

import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        // Logger logger = CustomLogManager.getLogger(Main.class.getName());
        CustomLogManager.resetFromPropertyFile("logging.properties");
        Logger logger = Logger.getLogger(Main.class.getName());
        // logger.setLevel(Level.ALL);
        logger.fine("warning test!");
    }

}
