package com.baerdev.ad.sw08.test;

import com.baerdev.ad.sw08.example.future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class Executor {

    private static Logger LOG = LogManager.getLogger(Executor.class);
    public static void main(String[] args){
        final Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 1; i <= 10000; i++) {
                sum += i;
            }
            return sum;
        };
        final ExecutorService executor = Executors.newCachedThreadPool();
        final Future<Integer> future = executor.submit(callable);
        try {
            LOG.info("Summe: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
