package com.baerdev.ad.SW04_2.BucketListTests;

import com.baerdev.ad.SW04_2.BucketHashSet.SingleLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class SingleLinkedListTests {
    @Test
    public void testSize() {
        SingleLinkedList list = new SingleLinkedList();
        for (char c = 'a'; c <= 'z'; c++) {
            list.add(c);
        }
        Assert.assertEquals('z' - 'a' + 1, list.getSize());
    }

    @Test
    public void testContainsAddedValues() {
        SingleLinkedList list = new SingleLinkedList();
        Assert.assertFalse(list.contains('a'));
        list.add('a');
        list.add('b');
        list.add('c');
        Assert.assertTrue(list.contains('a'));
        Assert.assertTrue(list.contains('b'));
        Assert.assertTrue(list.contains('c'));
    }

    @Test
    public void testRemoveValueBeginning() {
        SingleLinkedList list = new SingleLinkedList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.remove('c');
        Assert.assertTrue(list.contains('a'));
        Assert.assertTrue(list.contains('b'));
        Assert.assertFalse(list.contains('c'));
        Assert.assertEquals(2, list.getSize());
    }

    @Test
    public void testRemoveValueEnd() {
        SingleLinkedList list = new SingleLinkedList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.remove('b');
        Assert.assertTrue(list.contains('a'));
        Assert.assertFalse(list.contains('b'));
        Assert.assertTrue(list.contains('c'));
        Assert.assertEquals(2, list.getSize());
    }

    @Test
    public void testRemoveValueMiddle() {
        SingleLinkedList list = new SingleLinkedList();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.remove('c');
        Assert.assertTrue(list.contains('a'));
        Assert.assertTrue(list.contains('b'));
        Assert.assertFalse(list.contains('c'));
        Assert.assertTrue(list.contains('d'));
        Assert.assertTrue(list.contains('e'));
        Assert.assertEquals(4, list.getSize());
    }

    @Test
    public void testIterator() {
        SingleLinkedList list = new SingleLinkedList();
        list.add('a');
        list.add('b');
        list.add('c');
        Iterator<Object> iterator = list.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals('c', iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals('b', iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals('a', iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
}