package com.solvd.dice.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void create() {
        try {
            Thread.sleep(500);
            LOGGER.info("I create something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            Thread.sleep(500);
            LOGGER.info("I read something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            Thread.sleep(500);
            LOGGER.info("I update something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Thread.sleep(500);
            LOGGER.info("I delete something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
