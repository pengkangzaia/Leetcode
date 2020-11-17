package myanswer.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @FileName: No454.java
 * @Description: 四数相加2
 * @Author: admin
 * @Date: 2020/11/15 14:10
 */
public class No454 {

    // 暴力法
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // 用map优化
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            map.put(-1 * D[i], map.getOrDefault(-1 * D[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map.containsKey(A[i] + B[j] + C[k])) {
                        cnt += map.get(A[i] + B[j] + C[k]);
                    }
                }
            }
        }
        return cnt;
    }

    // 用map优化：更加优化版
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        // key为A+B元素之和，value为这个值在A+B的组合中出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put((A[i] + B[j]) * (-1), map.getOrDefault((A[i] + B[j]) * (-1), 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(C[i] + D[j])) {
                    cnt += map.get(C[i] + D[j]);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }


}
