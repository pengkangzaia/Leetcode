package MyAnswer.sort.easy;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
public class No976 {
    public static void main(String[] args) {
        int[] a = {3,6,2,3};

        int perimeter = largestPerimeter(a);
        System.out.println(perimeter);
    }

    private static int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            if(a[i-1]+a[i-2]>a[i]){
                return a[i]+a[i-1]+a[i-2];
            }
        }
        return 0;

    }
}
