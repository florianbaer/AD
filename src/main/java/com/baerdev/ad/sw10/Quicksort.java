package com.baerdev.ad.sw10;

public class Quicksort {
    private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
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
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        } // linke Hälfte
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }// rechte Hälfte, ohne T’Elt.
    }

    public static final void quickSort(final char[] a) {
        int left = 0;
        int right = a.length-1;
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
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        } // linke Hälfte
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }// rechte Hälfte, ohne T’Elt.
    }
}
