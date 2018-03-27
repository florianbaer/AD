package com.baerdev.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetThreadTest {

    private static final Logger LOG = LogManager.getLogger();

    public static void main(final String[] args) {
        // Anzahl der Prozessoren abfragen
        final int nr = Runtime.getRuntime().availableProcessors();
        LOG.info("Available processors " + nr);
        // Eigenschaften des main-Threads
        final Thread self = Thread.currentThread();
        LOG.info("Name: " + self.getName());
        LOG.info("Priority : " + self.getPriority());
        LOG.info("ID: " + self.getId());
    }
}
