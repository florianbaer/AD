package com.baerdev.ad.sw06;


    /*public class RaceHorse implements Runnable {
        private static final Logger LOG = LogManager.getLogger("RaceHorse");
        private final Sync startSignal;
        private volatile Thread runThread;
        private final Random random;

        public RaceHorse(Sync startSignal) {
            this.startSignal = startSignal;
            this.random = new Random();
        }

        @Override
        public void run() {
            runThread = Thread.currentThread();
            LOG.info("Rennpferd " + runThread.getName() + " geht in die Box.");

            try {
                startSignal.acquire();
                LOG.info("Rennpferd " + runThread.getName() + " laeuft los ...");
                Thread.sleep(random.nextInt(3000));
            } catch(InterruptedException ex) {
                LOG.info("Rennpferd " + runThread.getName() + " bricht ab.");
                return;
            }
            LOG.info("Rennpferd " + runThread.getName() + " ist im Ziel.");
        }
    }*/



