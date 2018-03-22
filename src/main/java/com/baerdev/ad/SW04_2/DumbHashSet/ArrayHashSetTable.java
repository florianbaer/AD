package com.baerdev.ad.SW04_2.DumbHashSet;

import java.lang.reflect.Array;

public class ArrayHashSetTable<T> implements HashSetTable<T> {
    private static int ARRAY_SIZE = 10;

    T[] data = null;

    public ArrayHashSetTable(){
        final T[] data = (T[]) new Object[ARRAY_SIZE];
        this.data = data;
    }

    @Override
    public void add(T item) {
        if(this.contains(item)){
            throw new IllegalArgumentException("The value is already in the set.");
        }
        data[getIndex(item)] = item;
    }

    private int getIndex(T item) {
        return item.hashCode() % ARRAY_SIZE;
    }

    @Override
    public boolean contains(T item) {
        return data[getIndex(item)] != null;
    }

    @Override
    public void remove(T item) {
        data[getIndex(item)] = null;
    }
}
