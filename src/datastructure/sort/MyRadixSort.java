package datastructure.sort;

import java.util.LinkedList;
import java.util.Queue;

public class MyRadixSort {

    public static void radixSort(int[] array) {
        // 获得最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 1; max / i > 0; i++) {
            int[][] bucket = new int[array.length][10];
            for (int j = 0; j < array.length; j++) {
                int num = array[j] / i % 10;
                bucket[j][num] = array[j];
            }

            int k = 0;
            for (int l = 0; l < 10; l++) {
                for (int j = 0; j < array.length; j++) {
                    if (bucket[j][l] != 0) {
                        array[k++]=bucket[j][l];
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {192,27928,212,11};
        radixSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
