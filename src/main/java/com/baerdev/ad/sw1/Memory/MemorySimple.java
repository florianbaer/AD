package com.baerdev.ad.sw1.Memory;

import java.util.LinkedList;
import java.util.List;

public class MemorySimple implements Memory {
    private final int totalSize;

    List<Allocation> allocations = new LinkedList<Allocation>();

    public MemorySimple(int memorySize) {
        this.totalSize = memorySize;
    }

    public Allocation malloc(int size){
        Allocation allocation =  new Allocation(allocations.stream().mapToInt(i -> i.getSize()).sum(), size);
        allocations.add(allocation);
        return allocation;
    }

    @Override
    public void free(Allocation alloc) {
        allocations.remove(alloc);
    }

    @Override
    public String toString() {
        int sum = allocations.stream().mapToInt(i -> i.getSize()).sum();
        return  String.format("MemorySimple[Belegt: %s; Frei: %s]", sum, this.totalSize - sum);
    }
}
