package com.baerdev.ad.sw05;

public final class MyTask implements Runnable {

    @Override
    public void run() {
    //...Anweisungen - nebenläufig ausführen
    }

    public static void main(final String[] args) {
        final MyTask myTask = new MyTask();
        final Thread thread = new Thread(myTask, "MyTask-Thread");
        thread.start();
    }
}