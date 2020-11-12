package myanswer.backtracking;

import myanswer.linkedlist.hard.ListNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No140.java
 * @Description: 单词拆分2
 * @Author: admin
 * @Date: 2020/9/25 14:35
 */
public class No140 {

    public List<String> res = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        StringBuilder sentence = new StringBuilder();
        traverse(s, sentence, set, 0);
        return res;
    }

    private void traverse(String s, StringBuilder sentence, HashSet<String> set, int index) {

        String s1 = sentence.toString();
        String replace = s1.replace(" ", "");
        if (replace.length() == s.length()) {
            res.add(new String(sentence).substring(0, sentence.length() - 1));
            return;
        }
        for (int i = index; i <= s.length(); i++) {
            String newWord = s.substring(index, i);
            if (set.contains(newWord)) {
                sentence.append(newWord);
                sentence.append(" ");
                traverse(s, sentence, set, i);
                sentence.delete(sentence.length() - newWord.length() - 1, sentence.length());
            }
        }
    }

    public static void main(String[] args) {
        No140 no140 = new No140();
        String s = "catsanddog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> strings = no140.wordBreak1(s, wordDict);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    // 需要根据dp数组进行剪枝，如果dp[i]不能分割为字符串，就不用继续判断
    public List<String> wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return res;
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        if (dp[n]) {
            dfs(s, new LinkedList<String>(), s.length(), set, dp);
        }
        return res;
    }

    // 用双端队列替代StringBuilder，可以实现从队列头部添加删除
    private void dfs(String s, LinkedList<String> path, int idx, HashSet<String> set, boolean[] dp) {

        if (idx <= 0) {
            String temp = String.join(" ", path);
            res.add(temp);
            return;
        }

        for (int i = idx; i >= 0; i--) {
            String subString = s.substring(i, idx);
            // 关键的一步，判断子串是否能被拆分。如果不能被拆分就直接不考虑
            if (set.contains(subString) && dp[i]) {
                path.addFirst(subString);
                dfs(s, path, i, set, dp);
                path.removeFirst();
            }
        }

    }


}
