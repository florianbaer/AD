package com.baerdev.ad.SW04_2.BucketHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BucketListHashTable<T> {
    public static final int SIZE = 10;

    private SingleLinkedList entries[] = new SingleLinkedList[SIZE];

    private int size = 0;

    public boolean put(T entry) {
        int index = calculateIndex(entry);
        if (entries[index] == null) {
            entries[index] = new SingleLinkedList();
        }
        if (entries[index].contains(entry)) {
            return false;
        }
        entries[index].add(entry);
        size++;
        return true;
    }

    public boolean remove(T entry) {
        int index = calculateIndex(entry);
        if (entries[index] == null || !entries[index].contains(entry)) {
            size--;
            return false;
        }
        return entries[index].remove(entry);
    }

    public T get(int hashCode) {
        int index = calculateIndex(hashCode);
        if (entries[index] == null) {
            throw new UnsupportedOperationException("Element does not exist");
        }
        Iterator<T> iterator = entries[index].iterator();
        while (iterator.hasNext()) {
            T entry = iterator.next();
            if (entry.hashCode() == hashCode) {
                return entry;
            }
        }
        throw new UnsupportedOperationException("Element does not exist");
    }

    public int getSize() {
        return size;
    }

    public Collection<T> getAllElements() {
        Collection<T> allElements = new ArrayList<>();
        for (int n = 0; n < entries.length; n++) {
            if (entries[n] != null) {
                Iterator<T> listEntries = entries[n].iterator();
                while (listEntries.hasNext()) {
                    allElements.add(listEntries.next());
                }
            }
        }
        return allElements;
    }

    private int calculateIndex(T entry) {
        return entry.hashCode() % SIZE;
    }

    private int calculateIndex(int hashCode) {
        return hashCode % SIZE;
    }
}
