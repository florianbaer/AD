package com.baerdev.ad.SW04_2.DumbHashSet;

import com.baerdev.ad.SW04_2.DumbHashSet.ArrayHashSetTable;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DumbHashSetTests {
    @Test
    @Category(ArrayHashSetTable.class)
    public void addElmentThatNotExistsAndVerifyContains(){
        ArrayHashSetTable<Integer> dumbHashSet = new ArrayHashSetTable<>();

        dumbHashSet.add(23);
        assertTrue(dumbHashSet.contains(23));
    }

    @Test(expected = IllegalArgumentException.class)
    @Category(ArrayHashSetTable.class)
    public void addElmentThatExists(){
        ArrayHashSetTable<Integer> dumbHashSet = new ArrayHashSetTable<>();

        dumbHashSet.add(23);
        dumbHashSet.add(23);
    }

    @Test
    @Category(ArrayHashSetTable.class)
    public void addElmentThatNotExistsAndRemove(){
        ArrayHashSetTable<Integer> dumbHashSet = new ArrayHashSetTable<>();

        dumbHashSet.add(23);
        assertTrue(dumbHashSet.contains(23));
        dumbHashSet.remove(23);
        assertFalse(dumbHashSet.contains(23));
    }

    @Test
    @Category(ArrayHashSetTable.class)
    public void fillArrayHashSetAndCheckIfItsFull(){
        ArrayHashSetTable<Integer> dumbHashSet = new ArrayHashSetTable<>();
        for (int count = 0; count < 10; count++){
            dumbHashSet.add(count);
        }

        assertTrue(dumbHashSet.isFull());
    }


    @Test
    @Category(ArrayHashSetTable.class)
    public void checkArrayHashSetWhichIsNotFullAndCheckIfItsFull(){
        ArrayHashSetTable<Integer> dumbHashSet = new ArrayHashSetTable<>();
        for (int count = 0; count < 5; count++){
            dumbHashSet.add(count);
        }

        assertFalse(dumbHashSet.isFull());
        assertEquals(5, dumbHashSet.size());
    }
}
