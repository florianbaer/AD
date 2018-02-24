package com.baerdev.ad.sw1.Memory;

import java.util.Objects;

public final class Allocation {

    public Allocation(int adress, int size){
        this.adress = adress;
        this.size = size;
    }

    private int adress;
    private int size = 0;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Allocation)){
            return false;
        }

        Allocation allocation = (Allocation)obj;

        if(allocation == this){
            return true;
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAdress(), this.getSize());
    }

    public int getSize() {
        return size;
    }

    public int getAdress() {
        return adress;
    }

    public void setAdress(int adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return String.format("Allocation[Address: %s; Size: %s]", this.getAdress(),this.getSize());
    }
}
