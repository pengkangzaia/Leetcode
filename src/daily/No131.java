package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No131.java
 * @Description: 分割回文串
 * @Author: admin
 * @Date: 2021/3/7 18:20
 */
public class No131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        char[] chars = s.toCharArray();
        traverse(res, path, chars, 0);
        return res;
    }


    private void traverse(List<List<String>> res, List<String> path, char[] chars, int idx) {
        if (idx == chars.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder currString = new StringBuilder();
        for (int i = idx; i < chars.length; i++) {
            currString.append(chars[i]);
            if (isPar(currString.toString())) {
                path.add(currString.toString());
                traverse(res, path, chars, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPar(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
