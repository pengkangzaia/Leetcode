package myanswer.string.medium;

import java.util.*;

/**
 * @FileName: No763.java
 * @Description: 划分字母区间
 * @Author: camille
 * @Date: 2021/2/20 19:55
 */
public class No763 {

    public List<Integer> partitionLabels(String S) {
        // 初始化区间
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            int[] arr = map.getOrDefault(S.charAt(i), new int[]{-1, -1});
            if (arr[0] == -1) {
                arr[0] = i;
            }
            arr[1] = i;
            map.put(S.charAt(i), arr);
        }

        int[][] arrays = new int[map.size()][2];
        int idx = 0;
        for (Character c : map.keySet()) {
            arrays[idx++] = map.get(c);
        }

        // lc56合并区间
        List<Integer> res = new LinkedList<>();
        Arrays.sort(arrays, (o1, o2) -> (o1[0] - o2[0]));
        int[] temp = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (temp[1] < arrays[i][0]) {
                res.add(temp[1] - temp[0] + 1); // 分段为两个区间
                // 更新区间
                temp = arrays[i];
            } else {
                if (temp[1] > arrays[i][1]) {
                    continue;
                } else {
                    temp[1] = arrays[i][1];
                }
            }
        }

        res.add(temp[1] - temp[0] + 1); // 别忘了最后一段
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            No763 no763 = new No763();
            List<Integer> ans = no763.partitionLabels(s);
            System.out.println(ans);
        }
    }


}
