package com.baerdev.ad.SW04_2.DumbHashSet;

public interface HashSetTable<T> {
    void add(T item);

    boolean contains(T item);

    void remove(T item);
}
