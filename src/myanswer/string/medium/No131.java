package myanswer.string.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No131.java
 * @Description: 分割回文串
 * @Author: admin
 * @Date: 2020/11/4 10:26
 */
public class No131 {

    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] letters = s.toCharArray();
        // 回溯
        dfs(letters, new LinkedList<String>(), 0);
        return res;
    }

    private void dfs(char[] letters, LinkedList<String> path, int idx) {
        if (idx == letters.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < letters.length; i++) {
            sb.append(letters[i]);
            if (isPalindrome(sb.toString())) {
                path.add(sb.toString());
                dfs(letters, path, i+1);
                path.removeLast();
            }
        }
    }


    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        No131 no131 = new No131();
        List<List<String>> results = no131.partition(s);
        for (List<String> result : results) {
            System.out.println(result);
        }
    }







}
