package sword2offer;

public class Question21 {

    public static void main(String[] args) {
        Question21 question21 = new Question21();
        int[] nums = {1, 2, 3, 4};
        int[] exchange = question21.exchange(nums);
        for (int i : exchange) {
            System.out.println(i);
        }
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            // i奇，j偶
            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                i++;
                j--;
            } else if (nums[i] % 2 == 1 && nums[j] % 2 == 1) {
                i++;
            } else if (nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                j--;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }

}
