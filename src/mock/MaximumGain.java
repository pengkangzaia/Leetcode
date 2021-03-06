package mock;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: MaximumGain.java
 * @Description: MaximumGain.java类说明
 * @Author: admin
 * @Date: 2021/3/5 11:40
 */
public class MaximumGain {

    /**
     * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
     * <p>
     * 删除子字符串 "ab" 并得到 x 分。
     * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
     * 删除子字符串"ba" 并得到 y 分。
     * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
     * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
     */


    // abaab
    // 每一个b最多只能被用一次，要么被x用，要么被y用，暴力解法会超时
    public int maximumGain(String s, int x, int y) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int score = 0;
        StringBuilder sb = new StringBuilder(s);
        String pattern = x >= y ? "ab" : "ba";
        int idx;
        while ((idx = sb.indexOf(pattern)) != -1) {
            sb.delete(idx, idx + 2);
            score += "ab".equals(pattern) ? x : y;
        }
        pattern = x >= y ? "ba" : "ab";
        while ((idx = sb.indexOf(pattern)) != -1) {
            sb.delete(idx, idx + 2);
            score += "ba".equals(pattern) ? y : x;
        }
        return score;
    }


    public static void main(String[] args) {
        MaximumGain solution = new MaximumGain();
        int ans = solution.maximumGain1("cdbcbbaaabab", 4, 5);
        String s = "feg";
        // 结束条件：长度小于2，没有a或者没有b
        // 跳出条件：没有ab或者没有ba
        //
        // cdbcbbaaa b
        // cdbcb aa b
        // cdbc a b
        // cdbc
        System.out.println(ans);
    }


    // 国际版lc讨论区解法 贪心+栈
    public int maximumGain1(String s, int x, int y) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int score = 0;
        char[] chars = s.toCharArray();
        score = x >= y ? x * count(chars, "ab") + y * count(chars, "ba") : y * count(chars, "ba") + x * count(chars, "ab");
        return score;
    }

    private int count(char[] chars, String pattern) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == pattern.charAt(0)) {
                stack.push(i);
            } else if (chars[i] == pattern.charAt(1)) {
                if (!stack.isEmpty()) {
                    res++;
                    // 修改char数组
                    chars[i] = ' ';
                    chars[stack.pop()] = ' ';
                }
            } else if (chars[i] == ' ') {
                continue;
            } else {
                stack.clear();
            }
        }
        return res;
    }


}
