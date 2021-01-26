package myanswer.array.easy;

public class No26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
        int i = removeDuplicates1(nums);
        System.out.println(i);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;  // 索引
        int j = 0;  // 不同元素的个数
        int n = nums.length - 1; // 数组长度

        while (i <= n - 1) {   // 判断到倒数第二个元素
            // 和下一个元素进行比较，如果相等则索引加一
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                // 如果不相等，则将值赋予给j，然后两个索引都加一。
                // 这样对i的下一次判断就不是之前的判断了
                j++;
                nums[j] = nums[i + 1];
                i++;
            }
        }
        return j + 1;
    }


    private static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0; // 不同元素的个数
        // 从下一个元素开始比较
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
