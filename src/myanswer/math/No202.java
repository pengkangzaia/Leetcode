package myanswer.math;

import java.util.HashSet;

/**
 * @FileName: No202.java
 * @Description: 快乐数
 * @Author: camille
 * @Date: 2020/11/21 12:38
 */
public class No202 {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = 0;
        while (true) {
            set.add(n);
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = temp;
            temp = 0;
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No202 no202 = new No202();
        boolean ans = no202.isHappy(18);
        System.out.println(ans);
    }

}
