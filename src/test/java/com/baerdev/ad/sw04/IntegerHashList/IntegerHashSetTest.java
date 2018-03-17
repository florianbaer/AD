package com.baerdev.ad.sw04.IntegerHashList;

import com.baerdev.ad.sw04.HashTable.DumbHashSet;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class IntegerHashSetTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testAdd() {
        DumbHashSet<Integer> set = new DumbHashSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(1));
    }

    @Test
    public void testContains() {
        DumbHashSet<Integer> set = new DumbHashSet<>();
        assertFalse(set.contains(34));
        set.add(3);
        assertTrue(set.contains(3));
    }

    @Test
    public void testRemove() {
        DumbHashSet<Integer> set = new DumbHashSet<>();
        set.add(34);
        assertTrue(set.contains(34));
        set.remove(34);
        assertFalse(set.contains(34));
    }
}