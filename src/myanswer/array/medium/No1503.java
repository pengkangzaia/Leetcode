package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No1503.java
 * @Description: 所有蚂蚁掉下来前的最后一刻
 * @Author: camille
 * @Date: 2021/2/28 17:34
 */
public class No1503 {

    public int getLastMoment(int n, int[] leftPoint, int[] rightPoint) {
        int res = 0;
        int[] left = new int[n + 1]; // 蚂蚁往左移动
        int[] right = new int[n + 1];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < leftPoint.length; i++) {
            left[leftPoint[i]]++;
        }
        for (int i = 0; i < rightPoint.length; i++) {
            right[rightPoint[i]]++;
        }
        while (true) {
            for (int i = right.length - 1; i >= 1; i--) {
                right[i] = right[i - 1];
            }
            right[0] = -1;
            for (int i = 0; i < left.length - 1; i++) {
                left[i] = left[i + 1];
            }
            left[n] = -1;
            // 不必特别处理交换位置，交换之后都一样的
            if (checkAndSwap(n, left, right)) {
                break;
            }
            res++;
        }
        return res;
    }

    private boolean checkAndSwap(int n, int[] left, int[] right) {
        for (int i = 0; i < n; i++) {
            if (left[i] != -1 || right[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1503 no1503 = new No1503();
        int ans = no1503.getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        System.out.println(ans);
    }


}
