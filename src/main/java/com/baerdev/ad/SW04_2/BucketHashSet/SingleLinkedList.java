package com.baerdev.ad.SW04_2.BucketHashSet;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {
    private Node start;


        private int size = 0;

        public void add(T value) {
            if (start == null) {
                start = new Node(value);
            } else {
                Node node = new Node(value);
                node.setNext(start);
                start = node;
            }
            size++;
        }

        public boolean contains(T value) {
            if (start == null) {
                return false;
            }
            Node tmp = start;
            do {
                if (tmp.getValue().equals(value)) {
                    return true;
                }
                tmp = tmp.getNext();
            } while (tmp != null);
            return false;
        }

        public int getSize() {
            return size;
        }

        public boolean remove(T value) {
            Node tmp = start;
            Node last = null;
            do {
                if (tmp.getValue().equals(value)) {
                    if (last == null) {
                        start = tmp.getNext();
                    } else {
                        last.setNext(tmp.getNext());
                    }
                    tmp.setNext(null);
                    size--;
                    return true;
                } else {
                    last = tmp;
                }
                tmp = tmp.getNext();
            } while (tmp != null);
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return new SingleLinkedListIterator(start);
        }
}