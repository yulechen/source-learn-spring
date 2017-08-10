package com.chinaway.jullog;

import java.util.logging.Logger;

import org.slf4j.bridge.SLF4JBridgeHandler;


public class Main {

    public static void main(String[] args) {
        SLF4JBridgeHandler.install();
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.fine("hello");
    }

}
