package com.oliver;

import java.util.Random;

public class TakeSample<T> {

    public void sample(T[] array, int k) {

        if(array == null || array.length == 0) throw new IllegalArgumentException("Array must not be empty or null.");
        if(k > array.length || k <= 0) throw new IllegalArgumentException("Sample size > dist size or sample size < 0");
        if(k == array.length) return;

        Random r = new Random();
        int storeSample = 0;

        // Optimization to limit the calls to Random to n / 2 where n is the length of the distribution.  Think of the
        // optimization as choosing which numbers to discard when k is greater than half the size of the distribution.
        if(k > array.length / 2) {
            k = array.length - k;
        }

        while(storeSample < k) {
            int from = storeSample + r.nextInt(array.length - storeSample);
            swap(storeSample, from, array);
            storeSample++;
        }
    }

    private void swap(int to, int from, T[] array) {

        T temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }
}