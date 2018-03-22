package com.baerdev.ad.SW04_2.MultipleArrayHashSet;

import java.util.Iterator;

public interface HashSetTable<T>{
    void add(T item);

    boolean contains(T item);

    void remove(T item);

    long size();

    boolean isFull();

    Iterator<T> getIterator();
}
