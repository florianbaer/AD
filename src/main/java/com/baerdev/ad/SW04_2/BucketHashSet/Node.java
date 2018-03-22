package com.baerdev.ad.SW04_2.BucketHashSet;

public class Node<T> {
    private T value;
    private Node next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }
}
