package com.baerdev.ad.sw04.HashTable;

public class DumbHashSet<T> implements HashSet<T> {
    private static int DEFAULT_ARRAY_SIZE = 10;

    private T[] items;

    public DumbHashSet() {
        @SuppressWarnings("unchecked")
        final T[] items = (T[]) new Object[DEFAULT_ARRAY_SIZE];
        this.items = items;
    }

    private int getIndex(T item) {
        return item.hashCode() % DEFAULT_ARRAY_SIZE;
    }

    @Override
    public boolean add(T item) {
        items[getIndex(item)] = item;
        return true;
    }

    @Override
    public boolean contains(T item) {
        return items[getIndex(item)] != null;
    }

    @Override
    public void remove(T item) {
        items[getIndex(item)] = null;
    }
}
