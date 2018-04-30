package com.baerdev.ad.sw10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class quicksorttests {
    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable(){
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        Quicksort.quickSort(aray, 0, aray.length-1);

        System.out.println(aray);
    }

    @Test
    @Category(Quicksort.class)
    public void getAllElementsFromTable2(){
        char[] aray = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        char[] aray2 = aray.clone();
        Quicksort.quickSort(aray, 0, aray.length-1);
        Quicksort.quickSort(aray2);

        System.out.println(aray2);

        Assert.assertArrayEquals(aray, aray2);
    }
}
