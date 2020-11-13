package myanswer.array.easy;

// 移动零
public class No283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = i;
        while (i <= nums.length - 1) {
            if (nums[i] != 0) {
                i++;
            } else {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length - 1 && nums[j] == 0) {
                    return;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
            j = i;
        }
    }


    // 双指针，i指向0，j指向0元素之后的第一个非0元素
    public void moveZeroes1(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 0) {
            i++;
        }
        int j = i;
        while (j < nums.length && nums[j] == 0) {
            j++;
        }
        while (j < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums= {1};
        No283 no283 = new No283();
        no283.moveZeroes1(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
