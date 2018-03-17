package com.baerdev.ad.sw2;

public class StackFullException extends Exception {
    /**
     * Set Serial Version UID for serialization.
     */
    private static final long serialVersionUID = -3281767409237943691L;

    public StackFullException(int size) {
        super(String.format("Stack with size of %d is full", size));
    }
}