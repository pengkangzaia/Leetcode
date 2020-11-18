package myanswer.math;

import java.util.HashMap;

/**
 * @FileName: No149.java
 * @Description: 直线上最多的点数
 * @Author: admin
 * @Date: 2020/11/18 11:11
 */
public class No149 {

    // 暴力解法
    public int maxPoints(int[][] points) {
        // 如果少于三个点，直接返回
        if (points.length < 3) {
            return points.length;
        }
        // 点可能都在同一个位置
        int count = 1;
        while (count < points.length) {
            if (points[count][1] != points[0][1] || points[count][0] != points[0][0]) {
                break;
            }
            count++;
        }
        if (count == points.length) {
            return points.length;
        }

        // 循环求最大值
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                int temp = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (inLine(points, i, j, k)) {
                            temp++;
                        }
                    }
                }
                res = Math.max(res, temp);
            }
        }
        // 结果要包括i点和j点
        return res + 2;
    }

    private boolean inLine(int[][] points, int i, int j, int k) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        int x = points[k][0];
        int y = points[k][1];
        // 防止除以0
        if (x == x1 && y == y1) {
            return true;
        }
        int g1 = gcd(y2 - y1, x2 - x1);
        int g2 = gcd(y - y1, x - x1);
        // 化简之后的分子分母都相等
        return ((y2 - y1) / g1 == (y - y1) / g2) && ((x2 - x1) / g1 == (x - x1) / g2);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,1},
                {1,1},
                {1,1}
        };
        No149 no149 = new No149();
        int ans = no149.maxPointsByMap(points);
        System.out.println(ans);
    }

    //=========================================================================================//
    //===============================解法2=====================================================//

    // 遍历所有的点，根据当前点，求和其他的点的斜率，把斜率放到map中。复杂度o(n2)
    public int maxPointsByMap(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        // key是斜率的分子和分母分别处以最大公约数得到的结果
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] currPoint = points[i];
            int temp = 0;
            int duplicate = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int x = currPoint[0];
                    int y = currPoint[1];
                    int x1 = points[j][0];
                    int y1 = points[j][1];
                    if (y == y1 && x == x1) {
                        duplicate++;
                        continue;
                    }
                    int g = gcd(y - y1, x - x1);
                    int k1 = (y - y1) / g; // 这个k不是斜率
                    int k2 = (x - x1) / g;
                    StringBuilder k = new StringBuilder().append(k1).append('@').append(k2);
                    temp = Math.max(temp, map.getOrDefault(k.toString(), 0) + 1);
                    map.put(k.toString(), map.getOrDefault(k.toString(), 0) + 1);
                }
            }
            map.clear();
            // 1为当前节点，dup为和当前节点重合的节点，temp为不重合的在一条直线上的节点
            res = Math.max(res, temp + duplicate + 1);
        }
        return res;
    }


}
