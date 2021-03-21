package weeklytest;

/**
 * @FileName: No5711.java
 * @Description: 有界数组中指定下标处的最大值
 * @Author: camille
 * @Date: 2021/3/21 12:10
 */
public class No5711 {

    //
    public int maxValue(int n, int index, int maxSum) {
        // left:从index到0的距离,right:从index到n的距离
        int left = index, right = n - index - 1;
        // 二分查找高，最小是1，最大是maxSum-(n-1)
        int lo = 1, hi = maxSum - (n - 1);
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int lmin = calc_min(left, mid - 1);
            int rmin = calc_min(right, mid - 1);
            if (lmin + rmin + mid > maxSum)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return hi;
        /*作者：吴自华
        链接：https://leetcode-cn.com/circle/discuss/RAHcuH/view/CSiahv/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }

    public int calc_min(int len, int hi) {
        if (len >= hi)
            // (len - hi)表示到1就不在继续减小了
            // 两部分面积组成，三角形面积+矩形面积
            return hi * (hi + 1) / 2 + (len - hi);
        // 梯形面积：上底加下底乘高除以二
        return (hi + hi - len + 1) * len / 2;
    }

    public static void main(String[] args) {
        No5711 no5711 = new No5711();
        int ans = no5711.maxValue(4, 2, 6);
        System.out.println(ans);
    }



}
