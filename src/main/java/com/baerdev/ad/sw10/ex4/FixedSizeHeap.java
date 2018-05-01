/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baerdev.ad.sw10.ex4;

import javax.swing.text.html.HTML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author Dave
 */
public class FixedSizeHeap implements IntegerHeap {

    private int counter;
    private int maxSize;
    private int[] heapdata;

    //Logg
    private static final Logger LOG = LogManager.getLogger(FixedSizeHeap.class);

    /**
     * Instanziert ein FixedSizeHeap Objekt.
     *
     * @param maxSize Maximale grösse des heaps.
     */
    public FixedSizeHeap(int maxSize) {
        this.counter = 0;
        this.maxSize = maxSize;
        this.heapdata = new int[maxSize];
    }

    @Override
    public void insert(int value) {
        if (fullHeap()){
           LOG.fatal("Heap Voll! Nichts eingefügt");
            return;
        }
        //Insert = simples einfügen an counter stelle
        heapdata[counter] = value;
        //nach einfügen, reorganisieren
        reorganize(counter);
        //counter aufzählen
        counter++;

    }

    @Override
    public boolean remove(int index) {
        boolean returnBool = true;
        LOG.info("hepdata: "+ heapdata[index]);
        try {
             ArrayUtils.remove(heapdata, index);
            //reorganisieren
            reorganizeMax(index);
            counter--;
        } catch (Exception e) {
            returnBool = false;
            return returnBool;
        }
        return returnBool;

    }

    @Override
    public int getMax() {
        int maxValue = heapdata[0];
        //Root Element auf 0 setzen
        //Blatt unten rechts zur Wurzel machen (counter)
        heapdata[0] = heapdata[counter - 1];
        ArrayUtils.remove(heapdata, counter - 1);
        counter--;
        //Reorganize ab root (0)
        reorganizeMax(0);
        return maxValue;
    }

    /**
     * Steigprozess.
     *
     * @param index
     */
    @Override
    public void reorganize(int index) {
        //prüfen ob child grösser als vater
        //aber nur wenn counter grösser als 1
        if (index < 1) {
            LOG.debug("nothing to switch index < 1");
            return;
        }
        //Formel um vom child den vaster zu finden: (index - 1) /2 {alles int werte}
        int parentindex = (index - (int) 1) / (int) 2;
        //falls kind grösser als vater -> switch
        if (heapdata[index] > heapdata[parentindex]) {
            int tmpVater = heapdata[parentindex];
            heapdata[parentindex] = heapdata[index];
            heapdata[index] = tmpVater;
            LOG.debug("switched Elements");
            //done, dann nochmals reorganized (rekursiv aufrufen)
            reorganize(parentindex);
        }
        LOG.debug("reorganized");
    }

    /**
     * Sinkprozess.
     *
     * @param index Index des obersten Elements (Root) -> Ab da an abwärts
     */
    public void reorganizeMax(int index) {
        //Hilfsattribute: wenn terminateleft oder right gesetzt sind, an bestimmter stelle im programm abbrechen
        boolean terminateleft = false;
        boolean terminateright = false;

        //prüfen ob child grösser als vater
        //aber nur wenn counter grösser als 1
        if (index >= counter) { //<- beim untersten Element aufhören
            LOG.debug("nothing to switch index > " + counter);
            return;
        }
        //Formel um vom child den vaster zu finden: (index - 1) /2 {alles int werte}
        int rightchildindex = ((int) 2 * (index + (int) 1));
        if (rightchildindex >= counter) {
            terminateright = true;
        }
        int leftchildindex = ((int) 2 * index) + (int) 1;
        if (leftchildindex >= counter) {
            terminateleft = true;
        }

        //falls kind grösser als vater -> switch
        //zuerst rightchild bearbeiten und wenn da nichts gefunden wird leftchild
        if (heapdata[index] <= heapdata[rightchildindex]) {
            //Falls terminateflag gesetzt wurde, abbrechen (no more child)
            if (terminateright) {
                return;
            }
            int tmpVater = heapdata[index];
            heapdata[index] = heapdata[rightchildindex];
            heapdata[rightchildindex] = tmpVater;
            LOG.debug("switched Elements");
            //done, dann nochmals reorganized (rekursiv aufrufen)
            reorganizeMax(rightchildindex);
            LOG.debug("reorganized [rightchild]");
        }//Und dann noch den linken ast durchgehen 
        if (heapdata[index] <= heapdata[leftchildindex]) {
            //Falls terminateflag gesetzt wurde, abbrechen (no more child)
            if (terminateleft) {
                return;
            }
            int tmpVater = heapdata[index];
            heapdata[index] = heapdata[leftchildindex];
            heapdata[leftchildindex] = tmpVater;
            LOG.debug("switched Elements");
            //done, dann nochmals reorganized (rekursiv aufrufen)
            reorganizeMax(leftchildindex);
            LOG.debug("reorganized [leftchild]");
        }

        LOG.debug(
                "reorganized");

    }

    @Override
    public boolean fullHeap() {
        if (counter == maxSize) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean emptyHeap() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printHeap() {
        boolean terminateleft = false;
        boolean terminateright = false;

        for (int i = 0; i < counter; i++) {

            LOG.debug("[Parent] -" + i + "- : " + heapdata[i]);
            int rightchildindex = ((int) 2 * (i + (int) 1));
            if (rightchildindex >= counter) {
                terminateright = true;
            }
            int leftchildindex = ((int) 2 * i) + (int) 1;
            if (leftchildindex >= counter) {
                terminateleft = true;
            }
            try {
                if (!terminateleft) {
                    LOG.debug("[LeftChild] -" + leftchildindex + "- : " + heapdata[leftchildindex]);
                }
            } catch (Exception e) {
                LOG.error("No Left Child");
            }
            try {
                if (!terminateright) {
                    LOG.debug("[RightChild] -" + rightchildindex + "- : " + heapdata[rightchildindex]);
                }
            } catch (Exception e) {
                LOG.error("No Right Child");
            }
        }
    }

    public int getLast() {
        return heapdata[counter - 1];
    }

}
