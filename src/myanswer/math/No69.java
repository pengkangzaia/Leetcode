package myanswer.math;

/**
 * @FileName: No69.java
 * @Description: x的平方根
 * @Author: admin
 * @Date: 2021/2/4 11:44
 */
public class No69 {

    // 二分查找最大的满足条件的值
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

}
