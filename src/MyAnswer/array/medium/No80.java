package MyAnswer.array.medium;

public class No80 {
    public static void main(String[] args) {
        
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
        System.out.println("=======================");
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0; //遍历nums的索引
        int j = 0; //代表不同的元素
        int m = 1; //m=1元素代表出现一次，=2代表元素出现两次
        int n = nums.length - 1;

        while (i <= n - 1) {
            //需要比较a[i]和a[i+1]的关系
            //所以i<=n-1

            //第一次相等
            if (m == 1 && nums[i] == nums[i + 1]) {
                j++;
                nums[j] = nums[i + 1];
                i++;
                m++;
                continue;
            }

            //第二次相等
            if (m == 2 && nums[i] == nums[i + 1]) {
                i++;
                continue;
            }

            //不相等
            if (nums[i] != nums[i + 1]) {
                j++;
                nums[j] = nums[i + 1];
                i++;
                m = 1;
                continue;
            }
        }
        return j + 1;
    }
}
