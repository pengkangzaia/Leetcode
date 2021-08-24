package myanswer.tree;

/**
 * @author 彭康
 * @create 2021-08-21 19:48
 **/
public class No440 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min(last, (long) (n + 1)) - first;
                first *= 10;
                last *= 10;
            }

            if (step > k) {
                //在树里
                k--;
                cur *= 10;
            }
            if (step <= k) {
                //不在树里
                k -= step;
                ++cur;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        No440 no440 = new No440();
        int ans = no440.findKthNumber(13, 2);
        System.out.println(ans);
    }


}
