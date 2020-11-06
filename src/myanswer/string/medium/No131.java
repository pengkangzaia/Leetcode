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
        // 回溯
        dfs(s, new LinkedList<String>());
        return res;
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

    public void dfs(String s, LinkedList<String> path) {
        if (s == null || s.length() == 0) {
            return;
        }
        

    }

}
