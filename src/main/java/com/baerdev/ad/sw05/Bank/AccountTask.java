package com.baerdev.ad.sw05.Bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountTask implements Runnable {

    private BankAccount source;
    private BankAccount target;
    private int amount;
    private static final Object LOCK = new Object();
    private static Logger LOG = LogManager.getLogger(AccountTask.class);

    public AccountTask(BankAccount source, BankAccount target, int amount){

        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (LOCK){
            final int amountToTransfer = 1;
            for (int i = 1; i < (this.amount + 1); i++) {
                this.source.transfer(this.target, amountToTransfer);
            }
            LOG.info(String.format("Source [%s] balance: %s",source.getId(), source.getBalance()));
            LOG.info(String.format("Target [%s] balance: %s",target.getId(), target.getBalance()));
        }
    }
}
