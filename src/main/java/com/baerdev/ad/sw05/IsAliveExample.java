package com.baerdev.ad.sw05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IsAliveExample {

    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {
        final MyTask myTask = new MyTask();
        final Thread thread = new Thread(myTask, "MyTask-Thread");
        thread.start();
        while (thread.isAlive()) {
            Thread.sleep(10);
            // Keine gute Idee!
        }
        for (int i = 0; i < 1000; i++) {
            LOG.info("x");
        }
    }
}
