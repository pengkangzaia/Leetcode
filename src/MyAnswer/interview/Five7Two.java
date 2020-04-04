package MyAnswer.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Five7Two {
    public static void main(String[] args) {
        int target = 100;
        int[][] ans = findContinuousSequence(target);
    }

    private static int[][] findContinuousSequence(int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = 2;
        int x = 0;
        while (((target-n*(n-1)/2)/n)>0){
            if((target-n*(n-1)/2)%n==0){
                x = (target-n*(n-1)/2)/n;
                hashMap.put(x,n);
            }
            n++;
        }
        int[][] ans = new int[hashMap.keySet().size()][];
        int i = 0;
        for (Integer numx : hashMap.keySet()) {
            int size = hashMap.get(numx);
            ans[i] = new int[size];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = numx + j;
            }
            i++;
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        return ans;
    }
}
