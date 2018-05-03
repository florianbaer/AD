package com.baerdev.ad.sw10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Timer;

public class quicksorttests {
    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable(){
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        Quicksort.quickSort1(aray, 0, aray.length-1);

        System.out.println(aray);
    }

    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable2(){
        System.out.println(Quicksort.randomChars(26));
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        char[] aray2 = aray.clone();
        Quicksort.quickSort1(aray, 0, aray.length-1);
        Quicksort.quickSort2(aray2);

        System.out.println(aray2);

        Assert.assertArrayEquals(aray, aray2);
    }


    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable3(){



        measureTime();
        measureTime();
        measureTime();
        measureTime();



    }

    public void measureTime (){
        char[] aray2 = Quicksort.randomChars(100000);
        long start = System.nanoTime();
        Quicksort.quickSort2(aray2);

        long end = System.nanoTime();


        System.out.println((end - start) / 1000000);
        System.out.println("miliseconds");
    }
}
