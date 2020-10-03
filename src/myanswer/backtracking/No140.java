package myanswer.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No140.java
 * @Description: 单词拆分
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
            res.add(new String(sentence).substring(0,sentence.length()-1));
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
        List<String> strings = no140.wordBreak(s, wordDict);
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
