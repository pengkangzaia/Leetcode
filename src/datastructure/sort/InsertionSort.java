package datastructure.sort;

/**
 * 插入排序
 * 使用for和内层while，需要复习！
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 10, 6, 5, 4, 3, 2, 1};
        int[] ans = insertionSort(array);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    // 插入排序
    // 设前i个元素为有序的，第i+1个元素插入到该数组中
    public static int[] insertionSort(int[] array) {
        // 从第一个元素开始，默认第0个元素为有序数组
        for (int i = 1; i <= array.length-1; i++) {
            int temp = array[i];
            while (i >= 1 && array[i - 1] > temp) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = temp;
        }
        return array;
    }

}
