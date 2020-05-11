package sword2offer;

public class Question39 {

    public static void main(String[] args) {
        int[] a= {3,3,4};
        int i = majorityElement(a);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Arrays.sort(nums);
        // return nums[(nums.length-1)/2];
        int votes = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                cur = nums[i];
            }
            if (cur != nums[i]) {
                votes--;
            } else if (cur == nums[i]) {
                votes++;
            }
        }

        return cur;


    }
}
