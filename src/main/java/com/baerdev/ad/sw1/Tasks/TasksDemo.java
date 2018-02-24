package com.baerdev.ad.sw1.Tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TasksDemo {
    public static final Logger LOG = LogManager.getLogger(TasksDemo.class);

    public static void main(String[] args){
        long startMilis = System.currentTimeMillis();
        LOG.info("Starting time: "+ startMilis);
        task(2);
        long endMilils = System.currentTimeMillis();
        LOG.info("End time:" + endMilils);
        LOG.info("Total execution time: " + (endMilils - startMilis));
    }

    public static void task(final int n){
        task1(); task1(); task1(); task1();
        for(int i = 0; i<n;i++){
            task2(); task2(); task2();
            for(int j = 0; j<n; j++){
                task3();task3();
            }
        }
    }

    public static void task1(){
        LOG.info("task 1");
    }

    public static void task2(){
        LOG.info("task 2");
    }

    public static void task3() {
        LOG.info("task 3");
    }
}
