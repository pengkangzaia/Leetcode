package datastructure.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ans = selectSort(array);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    private static int[] selectSort(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            // 选出最大值，插入到当前数组最后
            int index = 0;
            for (int j = 0; j <= array.length - i - 1; j++) {
                if (array[j] > array[index]) {
                    // 获得当前数组最大值所在位置
                    index = j;
                }
            }
            // 交换最大值元素和最末尾元素
            int temp = array[index];
            // 这里交换的元素位置为array.length - i - 1
            array[index] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;

    }

}
