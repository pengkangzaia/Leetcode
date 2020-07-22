package datastructure;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int key = array[left];
            int i = left;
            int j = right;
            while (i < j) {
                // 这里是大于等于
                while (array[j] >= key && i < j) {
                    j--;
                }
                while (array[i] <= key && i < j) {
                    i++;
                }
                if (i < j) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            array[left] = array[i];
            array[i] = key;
            quickSort(array, left, i - 1);
            quickSort(array, i+1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        quickSort(arr,0,4);
        System.out.println(Arrays.toString(arr));
    }

}
