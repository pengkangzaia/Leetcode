package mock;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: CanMakePaliQueries.java
 * @Description: CanMakePaliQueries.java类说明
 * @Author: camille
 * @Date: 2021/1/5 21:55
 */
public class CanMakePaliQueries {


    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            HashMap<Character, Integer> map = new HashMap<>();
            String subString = s.substring(query[0], query[1] + 1);
            for (int j = 0; j < subString.length(); j++) {
                map.put(subString.charAt(j), (map.getOrDefault(subString.charAt(j), 0) + 1) % 2);
            }
            int count = 0;
            for (Character c : map.keySet()) {
                if (map.get(c) == 1) {
                    count++;
                }
            }
            res.add(query[2] >= (count / 2));
        }
        return res;
    }

    public static void main(String[] args) {
        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        String s = "abcda";
        int[][] queries = {{3,3,0}, {1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> ans = canMakePaliQueries.canMakePaliQueries(s, queries);
        System.out.println(ans);
    }

}
