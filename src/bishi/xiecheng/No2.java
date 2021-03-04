package bishi.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @FileName: No2.java
 * @Description: 新春红包
 * @Author: admin
 * @Date: 2021/3/4 21:29
 */
public class No2 {

    // 未完成


    // 长度为m的数组切分为n+1个连续子数组，求所有情况中（每一种切分情况下，被切分的连续子数组和的最小值）的最大值
    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {
        // 将数组分割为n+1
        int m = packets.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += packets[i];
        }
        int max = sum / (n + 1);
        List<Integer> list = new ArrayList<>();
        int currSum = 0;
        for (int i = 0; i < m; i++) {
            if (currSum >= max) {
                list.add(currSum);
                currSum = packets[i];
            } else {
                currSum += packets[i];
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer integer : list) {
            res = Math.min(res, integer);
        }
        return res;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());

        int res = maxAmount(packets, n);
        System.out.println(res);
    }

    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }


}
