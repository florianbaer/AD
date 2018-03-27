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
            final int amountToTransfer = 1;
            for (int i = 1; i < (this.amount + 1); i++) {
                synchronized (LOCK) {
                    this.source.transfer(this.target, amountToTransfer);
                    LOG.info(String.format("Thread is now moving %s from Account %s to Account %s", amountToTransfer, source.getId(), target.getId()));
                }
                //LOG.info(String.format("Source [%s] balance: %s to Target [%s] balance: %s", source.getId(), source.getBalance(), target.getId(), target.getBalance()));
            }
            //LOG.info(String.format("Thread is now donw with the work to move %s from Account %s to Account %s", this.amount, source.getId(), target.getId()));
    }
}
