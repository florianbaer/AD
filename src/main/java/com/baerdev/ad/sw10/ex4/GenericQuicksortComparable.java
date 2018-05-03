package com.baerdev.ad.sw10.ex4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericQuicksortComparable {

    public static <T extends Comparable<T>> void qsort(T[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T erst = arr[(i + j) / 2];
            T zweit = arr[i];
            T dritt = arr[j];

            List<T> medianHelper = Arrays.asList(erst, zweit, dritt);

            Collections.sort(medianHelper);
            T x = medianHelper.get(1);


            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    }

    public static void main(String[] args) {
        Integer[] ia = {30, 20, 10, 5, 6, 99};
        GenericQuicksortComparable.qsort(ia, 0, ia.length-1);
        for(Integer i: ia) {
            System.out.println(i);
        }
        Character[] b = {'a','c', 'b'};
        GenericQuicksortComparable.qsort(b, 0, b.length-1);
        for(Character i: b) {
            System.out.println(i);
        }

        String[] c = {"adolf", "alfons", "Aargau"};
        GenericQuicksortComparable.qsort(c, 0, b.length-1);
        for(String i: c) {
            System.out.println(i);
        }
    }
}
