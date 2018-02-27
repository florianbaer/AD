package com.baerdev.ad.sw01.Ackermann;

public class Ackermann {
    public int ack(int n, int m){
        System.out.println(String.format("n: [%s], m:[%s]", n,m));
        if(n == 0){
            return m+1;
        }

        if(m == 0){
            return ack(n-1, 1);
        }

        return ack(n-1, ack(n, m-1));
    }

    public static void main(String[] args){
        new Ackermann().ack(4,1);
    }
}
