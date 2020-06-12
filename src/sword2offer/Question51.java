package sword2offer;

public class Question51 {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void merge(int[] nums, int start, int middle, int end) {
        int[] left = new int[middle - start];
        int[] right = new int[end - middle + 1];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[middle + i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
                k++;
            } else {
                nums[k] = right[j];
                count += left.length - i;
                j++;
                k++;
            }
        }
        while (i < left.length) {
            nums[k] = left[i];
            // count += right.length;
            i++;
            k++;
        }
        while (j < right.length) {
            nums[k] = right[j];
            k++;
            j++;
        }
    }


    // 归并排序
    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);
        merge(nums, start, middle + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        Question51 question51 = new Question51();
        int ans = question51.reversePairs(array);
        System.out.println(ans);
        // question51.mergeSort(array, 0, array.length - 1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }


}
