package com.baerdev.ad.sw05.Bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private static final List<BankAccount> sourceAccounts = new ArrayList<>();
    private static final List<BankAccount> destinationAccounts = new ArrayList<>();
    private static final Logger LOG = LogManager.getLogger(Program.class);

    public static void main(String[] args) throws InterruptedException {

        // Lege die Anzahl an Accounts fest
        final int numberOfAccounts = 10;

        // Lege den zu transferrierenden Betrag fest
        final int amount = 10000;

        // Account-Listen initialisieren
        initializeSourceAndDestiantionAccounts(numberOfAccounts);

        // Erstelle so viele Threads wie es Konten gibt und starte auf jedem Thread die
        // Überweisung
        final Thread[] threads = new Thread[numberOfAccounts * 2];
        for (int i = 0; i < numberOfAccounts; i++) {
            threads[i] = new Thread(new AccountTask(sourceAccounts.get(i), destinationAccounts.get(i),amount));
            threads[i + numberOfAccounts] = new Thread(new AccountTask(destinationAccounts.get(i), sourceAccounts.get(i),amount));
        }
        for (final Thread thread : threads) {
            thread.start();
        }

        // Diese Schleife wird erst dann verlassen, wenn alle Threads fertig sind
        for (final Thread thread : threads) {
            thread.join();
        }

        // Gib den Kontostand aller Konten nach den Überweisungen aus
        for (final BankAccount account : sourceAccounts) {
            LOG.info(account.toString());
        }
        for (final BankAccount account : destinationAccounts) {
            LOG.info(account.toString());
        }

    }

    private static void initializeSourceAndDestiantionAccounts(int amount) {
        // erstelle Ausganskonten und Einganskonten
        for (int i = 0; i < amount; i++) {
            sourceAccounts.add(new BankAccount());
            destinationAccounts.add(new BankAccount());
        }
    }

}