package datastructure.sort;

public class ShellSort {

    /**
     * 希尔排序，对数组进行分组
     * 然后对各个分组进行插入排序
     * gap表示组内元素间隔
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        for (int gap = array.length / 2; gap >= 1; gap = gap / 2) {
            // 1 2 3 4 5 6 7 8
            // i从5开始，一开始有4个组（1，5）（2，6）（3，7）（4，8）
            for (int i = gap; i <= array.length - 1; i++) {
                int j = i;
                int temp = array[j];
                while (j - gap >= 0 && array[j - gap] > temp) {
                    array[j - gap] = array[j];
                    j = j - gap;
                }
                array[j - gap] = temp;
            }
        }
        return array;
    }
}
