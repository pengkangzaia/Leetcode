package myanswer.array.easy;

public class No26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }

    private static int removeDuplicates(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }

        int i = 0;  //索引
        int j = 0;  //不同元素的个数
        int n = nums.length - 1;

        while (i <= n - 1) {   //判断到倒数第二个元素
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            } else {
                j++;
                nums[j] = nums[i + 1];
                i++;
            }
        }
        return j + 1;
    }
}
