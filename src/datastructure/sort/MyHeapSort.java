package datastructure.sort;

public class MyHeapSort {

    public static void main(String[] args) {
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 注意这里是i不是arr.length了
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] array, int parent, int length) {
        int temp = array[parent];
        int leftChild = parent * 2 + 1;
        while (leftChild < length) {
            if (leftChild + 1 < length && array[leftChild] < array[leftChild + 1]) {
                leftChild++;
            }
            if (temp >= array[leftChild]) {
                break;
            }
            // 覆盖前一个，因为比较的始终是temp和两个子节点的大小。也可以交换，但是效率会更低
            array[parent] = array[leftChild];
            parent = leftChild;
            leftChild = 2 * leftChild + 1;
        }
        array[parent] = temp;
    }


}
