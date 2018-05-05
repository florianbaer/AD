package com.baerdev.ad.sw10.Aufgabe2;

import com.baerdev.ad.sw10.Aufgabe2.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;
import java.util.Collections;

public class QuickSortTests {

    @Test
    @Category(com.baerdev.ad.sw10.Aufgabe2.Quicksort.class)
    public void orderAllSimpleKeyboardCharactersTest(){
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        Quicksort.quickSort(aray, 0, aray.length-1);

        System.out.println(aray);
    }

    @Test
    @Category(com.baerdev.ad.sw10.Quicksort.class)
    public void orderAllSimpleNumbersAsString(){
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        Quicksort.quickSort(aray, 0, aray.length-1);

        System.out.println(aray);
    }

    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable3(){
        measureTime(100000);
        measureTime(100000);
        measureTime(200000);
        measureTime(200000);
        measureTime(400000);
        measureTime(400000);
    }

    /*public void getMultipleMeasurementsAndCheckAverage(int length){
        double[] measurements = new double[4];
        measurements[0] = measureTime(length);
        measurements[1] = measureTime(length);
        measurements[2] = measureTime(length);
        measurements[3] = measureTime(length);

        System.out.println(String.format("Average duration %s", Arrays.asList(measurements).stream()
                .mapToDouble(a -> a)
                .average()));
    }*/

    public double measureTime (int lenght){
        char[] aray2 = Quicksort.randomChars(lenght);
        System.out.println(String.format("Measure with %s items.", aray2.length));
        long start = System.nanoTime();
        Quicksort.quickSort(aray2);

        long end = System.nanoTime();

        double duration = (end - start) / 1000000;

        System.out.println(String.format("Duration: %s miliseconds", duration));
        return duration;
    }
}
