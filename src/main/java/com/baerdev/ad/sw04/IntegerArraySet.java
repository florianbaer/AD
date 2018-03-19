package com.baerdev.ad.sw04;

public class IntegerArraySet implements ArraySet<Integer> {
    Integer[] array = new Integer[10];


    @Override
    public void add(Integer number) {
        array[getIndex(number)] = number;
    }

    private int getIndex(Integer number){
        return number.hashCode()%10;
    }

    @Override
    public boolean contains(Integer number) {
        return array[getIndex(number)] != null;
    }

    @Override
    public void remove(Integer number) {
        array[getIndex(number)] = null;
    }
}
