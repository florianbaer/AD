package com.baerdev.ad.sw2;

public interface Stack<E>
{	public boolean isEmpty();
    public boolean isFull();
    public int size();
    public boolean push(E element) throws StackFullException;
    public E pop();
    public E peek();
}