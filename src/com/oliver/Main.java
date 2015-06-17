package com.oliver;

public class Main {

    public static void main(String[] args) {

        TakeSample<Integer> ts = new TakeSample<Integer>();
        Integer[] dist = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ts.sample(dist, 6);
        for(Integer i : dist) {
            System.out.print(i + " ");
        }
    }
}
