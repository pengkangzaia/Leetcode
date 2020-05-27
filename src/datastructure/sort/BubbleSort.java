package datastructure.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ans = bubbleSort(array);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    /**
     * 冒泡排序算法
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < array.length; i++) {
            // 这里是从0开始，到末尾-i为止，因为第i个以后的数已经排好序了
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


}
