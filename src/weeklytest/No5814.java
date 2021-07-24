package weeklytest;

/**
 * @author 彭康
 * @create 2021-07-18 10:48
 **/
public class No5814 {

    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int curr = 0;
        for (int i = 0; i < rungs.length; i++) {
            int num = rungs[i];
            if (curr + dist < num) {
                if ((num - curr) % dist != 0) {
                    res += (num - curr) / dist;
                } else {
                    res += (num - curr) / dist - 1;
                }
            }
            curr = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,10};
        int dist = 2;
        No5814 no5814 = new No5814();
        int i = no5814.addRungs(nums, dist);
        System.out.println(i);
    }


}
