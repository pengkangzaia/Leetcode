package datastructure1.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(array, 0, array.length - 1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        // 这里为什么是m+1而不是m呢
        // 这里是为了确保下面的leftArray的长度和
        // 上面的mergeSort(array, left, middle)的长度一样
        merge(array, left, middle + 1, right);

    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] leftArray = new int[middle - left];
        int[] rightArray = new int[right - middle + 1];
        int i = 0;
        int j = 0;
        int k = left;
        for (int m = left; m <= middle - 1; m++) {
            leftArray[m - left] = array[m];
        }
        for (int m = middle; m <= right; m++) {
            rightArray[m - middle] = array[m];
        }
        while (i <= leftArray.length - 1 && j <= rightArray.length - 1) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                k++;
                i++;
            } else {
                array[k] = rightArray[j];
                k++;
                j++;
            }
        }
        while (i <= leftArray.length - 1) {
            array[k] = leftArray[i];
            k++;
            i++;
        }
        while (j <= rightArray.length - 1) {
            array[k] = rightArray[j];
            k++;
            j++;
        }

    }


}
