/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baerdev.ad.sw10.ex4;

/**
 *
 * @author Dave
 */
public interface IntegerHeap {
    
    /**
     * Fügt einen Integer Wert dem Heap hinzu.
     * @param value 
     */
    public void insert(int value);
    
    /**
     * Entfernt einen Integer Wert falls er vorhanden ist.
     * @param index Index an welchem der zu entfernende Wert steht
     * @return true falls der Wert existierte, false falls nicht
     */
    public boolean remove(int index);
    
    /**
     * Gibt den grössten Integer Wert des Heaps zurück.
     * @return 
     */
    public int getMax();
    
    /**
     * Reorganisiert den Heap (z.B. nach einer Werte entnahme).
     * @param index Index des neusten Elements
     */
    public void reorganize(int index);
    
    /**
     * Gibt zurück ob der Heap voll ist.
     * @return true falls voll, false falls nicht
     */
    public boolean fullHeap();
    
    /**
     * Gibt zurück ob der Heap leer ist.
     * @return true falls leer, false falls nicht.
     */
    public boolean emptyHeap();
    
    
}
