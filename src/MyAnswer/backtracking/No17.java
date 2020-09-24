package MyAnswer.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No17.java
 * @Description: 电话号码对应的字母
 * @Author: admin
 * @Date: 2020/9/24 11:50
 */
public class No17 {


    public List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        int n = digits.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        char[][] map = {
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[n];
        traverse(nums, path, map, 0);
        return res;
    }

    public void traverse(int[] nums, StringBuilder path, char[][] map, int index) {
        if (path.length() == nums.length) {
            res.add(new String(path));
            return;
        }
        char[] chars = map[nums[index] - 2];
        for (int j = 0; j < chars.length; j++) {
            path.append(map[nums[index] - 2][j]);
            traverse(nums, path, map, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        No17 no17 = new No17();
        List<String> strings = no17.letterCombinations("23");
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
