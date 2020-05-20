package datastructure1.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1,1,1,8};
        quickSort(array, 0, array.length - 1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }


    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            //为什么要先j后i呢
            // i在大于基准数的地方停下，j在小于基准数的地方停下，
            // 如果i先走，最后停下跟基准数交换时，总是大于基准数的。
            while (array[j] >= key && i < j) {
                j--;
            }
            while (array[i] <= key && i < j) {
                i++;
            }
//            while (array[j] >= key && i < j) {
//                j--;
//            }
            // 交换两个值
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }


}
