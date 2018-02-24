package com.baerdev.ad.sw1.Memory;

public interface Memory {
    public Allocation malloc(int size);
    public void free(Allocation alloc);
}
