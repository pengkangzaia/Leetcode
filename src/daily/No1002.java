package daily;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No1002.java
 * @Description: No1002.java类说明
 * @Author: camille
 * @Date: 2020/10/14 21:57
 */
public class No1002 {

    public List<String> commonChars(String[] A) {
        if (A.length == 0) {
            return new LinkedList<>();
        }
        int[] res = new int[26];
        String s1 = A[0];
        for (int i = 0; i < s1.length(); i++) {
            res[s1.charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                int index = A[i].charAt(j) - 'a';
                if (res[index] <= 0) {
                    res[index]--;
                } else {
                    temp[index]++;
                }
            }
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (res[i] > 0) {
                ans.add(String.valueOf(c));
                res[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        No1002 no1002 = new No1002();
        List<String> strings = no1002.commonChars(A);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

}
