/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package test;

/**
 * @FileName: MatrixTest.java
 * @Description: MatrixTest.java类说明
 * @Author: admin
 * @Date: 2020/9/22 15:56
 */
public class MatrixTest {

    public static void main(String[] args) {
        // 统计对角线元素值
        int n = 4;
        boolean[][] visit = {
                {true,false,false,false},
                {false,false,false,true},
                {false,true,false,false},
                {true,false,false,false}
        };
        MatrixTest test = new MatrixTest();
        boolean valid = test.isValid(visit, 3, 1);
        System.out.println(valid);

    }

    public boolean isValid(boolean[][] visit, int a, int b) {

        int n = visit.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a != i && visit[i][b]) {
                cnt++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (b != j && visit[a][j]) {
                cnt++;
            }
        }
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                if (Math.abs(i - a) == Math.abs(j - b) && (a != i) && (b != j) && visit[i][j]) {
                    cnt++;
                }
            }
        }
        if (cnt >= 1) {
            return false;
        } else {
            return true;
        }

    }

}
