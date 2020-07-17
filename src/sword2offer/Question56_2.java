package sword2offer;

public class Question56_2 {

    public int singleNumber(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int res = -1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(nums[i])) {
        //         map.put(nums[i], map.get(nums[i]) + 1);
        //     } else {
        //         map.put(nums[i], 1);
        //     }
        // }
        // for (Integer key : map.keySet()) {
        //     if (map.get(key) == 1) {
        //         res = key;
        //         break;
        //     }
        // }
        // return res;

        // 把每一个数字的每一位加起来，
        // 如果是出现三次的数，那么该值能被三整除
        // 否则不能
        int[] count = new int[32];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < count.length; j++) {
                count[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 3 != 0) {
                // 注意这里不能用 2 ^ i，在Java中 ^ 表示异或
                res += Math.pow(2, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question56_2 question56_2 = new Question56_2();
        int[] nums = {9,1,7,9,7,9,7};
        int ans = question56_2.singleNumber(nums);
        System.out.println(ans);
    }


}
