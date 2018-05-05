package com.baerdev.ad.sw10.Aufgabe2;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen‐Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static final void exchange(final char[] a,
                                       final int firstIndex,
                                       final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left;                  // linke Grenze
        int down = right - 1;           // rechte Grenze (ohne Trennelement)
        char t = a[right];              // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--;                 // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) {            // solange keine Überschneidung
                exchange(a, up, down);
                up++; down--;           // linke und rechte Grenze verschieben
            } else {
                allChecked = true;      // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1));  // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    public static final void quickSort(final char[] a) { //1,5,100

        //Challenge: define left and right
        int up = 0; // linke Grenze
        int down = (a.length - 1); // rechte Grenze (ohne Trennelement)
        char t = a[down]; // rechtes Element als Trennelement
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
        exchange(a, up, (a.length - 1)); // Trennelement an endgültige Position (a[up])

        //jetzt: Statt links und rechts zu übergegebn, übergeben wir einfach ein linkes und ein rechtes array
        if (0 < (up - 1)) { //<- dieser vergleich ist nur da um zu schauen ob es mehr als 2 elemente übrig sind
            quickSort(a, 0, (up - 1)); // linke Hälfte

        }
        if ((up + 1) < a.length - 1) {
            //Rechts: Start bei Trenn+1, Ende bei a.lenght
            quickSort(a, (up + 1), (a.length - 1)); // rechte Hälfte, ohne T’Elt.
        }
    }

    //Create Random Size Char Array
    public static char[] randomChars(final int length) {

        char myCharArray[] = new char[length];
        Random r = new Random();

        // Array befüllen
        for (int i = 0; i < length; i++) {
            myCharArray[i] = (char) (r.nextInt(26) + 97);
            //System.out.print(myCharArray[i]);
        }
        return myCharArray;

    }
}
