package myanswer.math;

/**
 * @FileName: No204_2.java
 * @Description: 计算质数2刷
 * @Author: admin
 * @Date: 2020/12/3 10:25
 */
public class No204_2 {

    public int countPrimes(int n) {
        // 1不是质数
        if (n < 2) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                continue;
            }
            int t = 2 * i;
            while (t < n) {
                prime[t] = true;
                t += i;
            }
        }
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No204_2 no204_2 = new No204_2();
        int ans = no204_2.countPrimes(200);
        System.out.println(ans);
    }

}
