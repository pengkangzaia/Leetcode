package test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @FileName: AqsTest.java
 * @Description: AqsTest.java类说明
 * @Author: camille
 * @Date: 2021/2/23 8:16
 */
public class AqsTest extends AbstractQueuedSynchronizer {


    public boolean canThreePartsEqualSum(int[] arr) {
        // 22：00
        // 前缀和+遍历
        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        // i最多取倒数第三个，j最多取倒数第二个
        for (int i = 0; i <= arr.length - 3; i++) {
            for (int j = i + 1; j <= arr.length - 2; j++) {
                if (arr[i] == arr[j] - arr[i] && arr[i] == arr[n - 1] - arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,1,-1};
        AqsTest a = new AqsTest();
        boolean ans = a.canThreePartsEqualSum(arr);
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        sb.append("fwieu");
    }


}
