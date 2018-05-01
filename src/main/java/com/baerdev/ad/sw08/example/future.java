package com.baerdev.ad.sw08.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class future {

    private static Logger LOG = LogManager.getLogger(future.class);
/*
    public static void main(String[] args){
        final Callable<Integer> callable = () -> {

            int sum = 0;
            for (int i = 1; i <= 10000; i++) {
                sum += i;
            }

            return sum;
        };
        final FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask, "Future Task Thread").start();
        try {
            LOG.info("Summe: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }*/



    public static void main(String[] args) throws ExecutionException, InterruptedException {


        final ExecutorService executor = Executors.newCachedThreadPool();


        Future<Object> answer = executor.submit((Callable<Object>) () -> {

            // tut was nebenläufiges...

            return null;

        });


        LOG.debug(answer.get());

        executor.execute((Runnable) () -> {

            // tut was nebenläufiges...

        });

        answer = executor.submit((Runnable) () -> {

            // tut was nebenläufiges...

        }, null);
        LOG.debug(answer.get());

        Future<?> result = executor.submit((Runnable) () -> {

            // tut was nebenläufiges...

        });
        LOG.debug(result.get());
    }
}
