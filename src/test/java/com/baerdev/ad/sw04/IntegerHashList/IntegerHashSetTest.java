package com.baerdev.ad.sw04.IntegerHashList;

import com.baerdev.ad.sw04.HashTable.IntegerHashSet;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class IntegerHashSetTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testAdd() {
        IntegerHashSet<Integer> set = new IntegerHashSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(1));
    }

    @Test
    public void testContains() {
        IntegerHashSet<Integer> set = new IntegerHashSet<>();
        assertFalse(set.contains(34));
        set.add(3);
        assertTrue(set.contains(3));
    }

    @Test
    public void testRemove() {
        IntegerHashSet<Integer> set = new IntegerHashSet<>();
        set.add(34);
        assertTrue(set.contains(34));
        set.remove(34);
        assertFalse(set.contains(34));
    }
}