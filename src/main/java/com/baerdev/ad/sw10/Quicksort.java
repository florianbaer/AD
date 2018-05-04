package com.baerdev.ad.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Quicksort {
    private static final Logger LOG = LogManager.getLogger(Quicksort.class);

    public static void insertionSort(final int[] a) {
        int elt;
        int j;
        for (int i = 1; i < a.length; i++) {
            elt = a[i]; // next elt for insert
            LOG.debug("[ELT] Array[" + i + "/" + a.length + "] | Element:" + elt);

            j = i; // a[0]..a[j‐1] already sorted
            while ((j > 0) && (a[j - 1] > elt)) {
                LOG.debug("j =" + j);
                LOG.debug("a[j-1]>elt --> " + a[j - 1] + ">" + elt);
                int tmp = a[j];
                a[j] = a[j - 1]; // shift right
                LOG.debug("a[j] = a[j-1] --> Stelle (" + j + ") neu mit (" + a[j - 1] + ") füllen");
                j--; // go further left
            }
            LOG.debug("a[" + j + "] = elt(" + elt + ") --> " + a[j] + "=" + elt);
            a[j] = elt; // insert elt
            LOG.warn("Array so far: ");

            for (int x = 0; x <= i; x++) {
                LOG.warn("[" + x + "/" + i + "]: " + a[x]);
            }
            LOG.info("------");
        } // a[0]...a[j] sorted
    }

    //insertionSort2
    /**
     * Sortiert das int‐Array aufsteigend, erst ab Index a[1]. --> Neu so dass
     * ab Index 0 sortiert wird
     *
     * @param a Zu sortierendes Array.
     */
    public static void insertionSort2(final int[] array) {
        int elt;
        int j;
        for (int index = 1; index < (array.length); index++) {
            elt = array[index]; // next elt for insert
            j = index; // array[0]..array[j‐1] already sorted
            while (j > 0 && array[j - 1] > elt) {
                array[j] = array[j - 1]; // shift right
                j--; // go further left
            }
            array[j] = elt; // insert elt
        } // array[0]...array[j] sorted
    }

    //insertionSort2
    /**
     * Sortiert das int‐Array aufsteigend, erst ab Index a[1]. --> Neu so dass
     * ab Index 0 sortiert wird
     *
     * @param a Zu sortierendes Array.
     */
    public static void insertionSort2(final char[] array, int left, int right) {
        char elt;
        int j;
        for (int index = left; index < right; index++) {
            elt = array[index]; // next elt for insert
            j = index; // array[0]..array[j‐1] already sorted
            while (j > 0 && array[j - 1] > elt) {
                array[j] = array[j - 1]; // shift right
                j--; // go further left
            }
            array[j] = elt; // insert elt
        } // array[0]...array[j] sorted
    }

    public static void selectionSort(final int[] a) {
        LOG.fatal("Initial Array: ");

        for (int x = 0; x < a.length; x++) {
            LOG.fatal("[" + x + "/" + (a.length - 1) + "]: " + a[x]);
        }

        //Schleife 1 für selected place
        //schleife 2 für selected place bis ende kontrollieren
        for (int selected = 0; selected < a.length; selected++) {
            LOG.debug("[selected] : (" + selected + "/" + a.length + ")");
            for (int i = selected; i < a.length; i++) {
                LOG.debug("[iterator] : (" + i + "/" + a.length + ")");
                if (a[i] < a[selected]) {
                    LOG.debug("a[" + i + "]<a[" + selected + "]");
                    //Rochade
                    int tmp = a[selected];
                    a[selected] = a[i];
                    a[i] = tmp;
                    LOG.debug("Rochade: " + a[selected] + " mit " + a[i] + " getauscht");
                }
            }
            LOG.warn("Array so far: ");

            for (int x = 0; x <= selected; x++) {
                LOG.warn("[" + x + "/" + (a.length - 1) + "]: " + a[x]);
            }
            for (int y = selected + 1; y < a.length; y++) {
                LOG.fatal("[" + y + "/" + (a.length - 1) + "]: " + a[y]);

            }
            LOG.info("------");
        }
    }

    public static void bubbleSort(final int[] a) {
        //umgekehrte selection Sort here
        LOG.fatal("Initial Array: ");

        for (int x = 0; x < a.length; x++) {
            LOG.fatal("[" + x + "/" + (a.length - 1) + "]: " + a[x]);
        }
        //es braucht nur eine schleife
        int ProcessingArraySize = (a.length - 1);

        while (ProcessingArraySize >= 0) {
            for (int selected = 0; selected < ProcessingArraySize; selected++) {
                //do some magic here
                if (a[selected + 1] < a[selected]) {
                    //falls der nächste kleiner ist als der ausgewählte -> rochade
                    int tmp = a[selected];
                    a[selected] = a[selected + 1];
                    a[selected + 1] = tmp;
                }
            }
            //Array so far
            LOG.warn("Array so far: ");

            for (int x = 0; x <= ProcessingArraySize - 1; x++) {
                LOG.fatal("[" + x + "/" + (a.length - 1) + "]: " + a[x]);
            }
            for (int y = ProcessingArraySize; y < a.length; y++) {
                LOG.warn("[" + y + "/" + (a.length - 1) + "]: " + a[y]);

            }
            //Wenn forschleife zu Ende, Processingarray

            ProcessingArraySize--;

        }
    }

    //Quicksort
    public static final void quickSort1(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
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
            quickSort1(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort1(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
        }
    }

    //Quicksort without left and right
    public static final void quickSort2(final char[] a) { //1,5,100

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
            quickSort1(a, 0, (up - 1)); // linke Hälfte

        }
        if ((up + 1) < a.length - 1) {
            //Rechts: Start bei Trenn+1, Ende bei a.lenght
            quickSort1(a, (up + 1), (a.length - 1)); // rechte Hälfte, ohne T’Elt.
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

    /**
     * Sortiert Teilfolgen n < M mit Insertion Sort zu Ende. @param a Array @
     *
     * p
     * aram left Lin
     *
     * ke Grenze
     * @param right Rechte Grenze
     */
    public static void quickInsertionSort(final char[] a, int left, int right) {
        int M = 25;
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
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
            //n<M prüfen
            if (((up - 1) - left) < M) {
                // LOG.debug("Choose InsertionSort (n = " + ((up - 1) - left) + ")");
                insertionSort2(a, left, (up - 1));
            } else {
                //LOG.debug("Choose Quicksort (n = " + ((up - 1) - left) + ")");
                quickInsertionSort(a, left, (up - 1));
                //quickSort1(a, left, (up - 1)); // linke Hälfte
            }
        }
        if ((up + 1) < right) {
            if ((right - (up + 1)) < M) {
                // LOG.debug("Choose InsertionSort (n = " + (right - (up + 1)) + ")");

                insertionSort2(a, (up + 1), right);
            } else {
                //LOG.debug("Choose Quicksort (n = " + (right - (up + 1)) + ")");
                quickInsertionSort(a, (up + 1), right);
                //quickSort1(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
            }
        }
    }

    //Hilfsmethode Exchange
    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
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
}
