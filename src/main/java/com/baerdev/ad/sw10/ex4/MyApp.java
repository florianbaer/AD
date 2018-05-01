/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baerdev.ad.sw10.ex4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Dave
 */
public class MyApp {

    private static final Logger LOG = LogManager.getLogger(MyApp.class);

    public static void main(final String args[]) throws InterruptedException {
        LOG.debug("Demo gestartet");

        LOG.debug("initialisiere Heap");
        FixedSizeHeap myHeap = new FixedSizeHeap(15);
        LOG.info("emptyHeap?: " + myHeap.emptyHeap());

        myHeap.insert(17);
        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(9);
        myHeap.insert(4);
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.insert(3);
        myHeap.insert(8);
        myHeap.insert(13);
        myHeap.insert(15);
        myHeap.insert(12);

        myHeap.printHeap();

        LOG.debug("Last Item: " + myHeap.getLast());
        LOG.debug("Remove max: " + myHeap.getMax());

        LOG.info("Reprint Array (7 should be max)");

        myHeap.printHeap();

        LOG.info("Entferne Element an Index 7 und reprint");
        LOG.info("Entfernen erfolgreich?: " + myHeap.remove(7));
        myHeap.printHeap();

        LOG.info("Entferne Element, welches nicht existiert");
        LOG.info("Entfernen erfolgreich?: " + myHeap.remove(14));

        LOG.info("fullHeap?: " + myHeap.fullHeap());
        myHeap.insert(29);
        myHeap.insert(30);
        myHeap.insert(31);
        myHeap.insert(32);
        myHeap.insert(33);

        myHeap.printHeap();
        myHeap.insert(34);

        LOG.info("fullHeap?: " + myHeap.fullHeap());
        LOG.info("emptyHeap?: " + myHeap.emptyHeap());

    }
}
