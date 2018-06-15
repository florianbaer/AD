package com.baerdev.ad.Atomic;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    public static void main(String[] args){
        AtomicInteger integer = new AtomicInteger(12);
        System.out.println(integer.get());
        Integer valu = integer.incrementAndGet();
        System.out.println(valu);


    }
}
