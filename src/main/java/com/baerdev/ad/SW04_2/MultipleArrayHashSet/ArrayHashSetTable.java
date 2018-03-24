package com.baerdev.ad.SW04_2.MultipleArrayHashSet;


import javax.management.openmbean.InvalidOpenTypeException;
import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayHashSetTable<T> implements HashSetTable<T> {
    private static int ARRAY_SIZE = 10;

    T[] data = null;

    public ArrayHashSetTable() {
        final T[] data = (T[]) new Object[ARRAY_SIZE];
        this.data = data;
    }

    @Override
    public void add(T item) {
        if (this.isFull()) {
            throw new UnsupportedOperationException("The set is already full."); // eigene Exception
        }

        boolean insertPending = true;

        if (data[getIndex(item)] == null) {
            data[getIndex(item)] = item;
        } else {
            for (int offset = 0; (offset < data.length - 1) && insertPending; offset++) {
                if (data[(getIndex(item) + offset) % ARRAY_SIZE] == null) {
                    data[(getIndex(item) + offset) % ARRAY_SIZE] = item;
                    insertPending = false;
                }
            }
        }
    }

    private int getIndex(T item) {
        return item.hashCode() % ARRAY_SIZE;
    }

    @Override
    public boolean contains(T item) {
        for (int offset = 0; offset < data.length - 1; offset++) {
            if (data[(getIndex(item) + offset) % ARRAY_SIZE] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T item) {
        if (this.contains(item)) {
            for (int offset = 0; offset < data.length - 1; offset++) {
                if (data[(getIndex(item) + offset) % ARRAY_SIZE] == item) {
                    data[(getIndex(item) + offset) % ARRAY_SIZE] = null; // tombstone nicht vergessen
                }
            }
        } else {
            throw new UnsupportedOperationException("Set does not contain element.");
        }
    }

    @Override
    public long size() {
        return Arrays.stream(this.data).filter(x -> x != null).count();
    }

    @Override
    public boolean isFull() {
        return Arrays.stream(this.data).allMatch(x -> x != null);
    }

    public Iterator<T> getIterator() {
        return new Iterator<T>() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return getNext(false) != null;
            }

            private T getNext(boolean updateCurrent) {
                T currentNode;
                for (int i = current; i < data.length; i++) {
                    currentNode = data[i];
                    if (currentNode != null) {
                        if (updateCurrent) {
                            current = i + 1;
                        }
                        return currentNode;
                    }
                }

                return null;
            }

            @Override
            public T next() {
                T node = getNext(true);
                if (node == null) {
                    throw new NoSuchElementException();
                }
                return node;
            }

        };
    }
}
