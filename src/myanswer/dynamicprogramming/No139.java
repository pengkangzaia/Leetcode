package myanswer.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No139.java
 * @Description: 单词拆分
 * @Author: admin
 * @Date: 2020/9/25 16:17
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int maxLength = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            maxLength = Math.max(wordDict.get(i).length(), maxLength);
        }
        for (int i = 1; i <= n; i++) {
            // 优化1：只需要查看wordDict中的最长字符串长度的范围即可
            // 注意：j需要从后往前数，因为j=0,i=5时，j+4>=5不满足，会直接跳出循环
            for (int j = i - 1; j >= 0 && j + maxLength >= i; j--) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No139 no139 = new No139();
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = no139.wordBreak(s, wordDict);
        System.out.println(b);
    }

}
