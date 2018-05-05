package com.baerdev.ad.sw10;

import java.util.Random;

public class Sort {
    private static final void swap(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    private static final void swap(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1;        // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                Sort.swap(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        Sort.swap(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        } // linke Hälfte
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }// rechte Hälfte, ohne T’Elt.
    }

    public static char[] randomChars(final int lenght) {
        Random rand = new Random();
        char[] chararray = new char[lenght];
        for (int i = 0; i <= lenght - 1; i++) {

            int min = 65;
            int max = min + 25;
            chararray[i] = (char) (rand.nextInt(max - min + 1) + min);
        }

        return chararray;
    }

    /**
     * Sortiert das int‐Array aufsteigend, mit Insertion-Sort
     *
     * @param a
     *            Zu sortierendes Array.
     */
    public static void insertionSort(final char[] a) {
        for (int i = 0; i < a.length; i++) {
            int current = i;
            if (current != a.length - 1) {
                while (a[current] > a[current + 1]) {
                    Sort.swap(a, current, current + 1);
                    if (current != 0) {
                        current--;
                    }
                }
            }
        }
    }

    /**
     * Sortiert das int-Array aufsteigend, mit Selection-Sort
     *
     * @param a
     */
    public static void selectionSort(final int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            int lowestValue = i + 1;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[lowestValue]) {
                    lowestValue = j;
                }
            }
            Sort.swap(a, i, lowestValue);
        }
    }
}
