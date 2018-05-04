package com.baerdev.ad.SW04_2.BucketHashSet;

import java.util.Iterator;

public class SingleLinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public SingleLinkedListIterator(Node start) {
        current = start;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        Node<T> node = current;
        current = node.getNext();
        return node.getValue();
    }
}