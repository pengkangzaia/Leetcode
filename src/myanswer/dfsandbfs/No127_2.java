package myanswer.dfsandbfs;

import java.util.*;

/**
 * @FileName: No127_2.java
 * @Description: 单词接龙2刷
 * @Author: admin
 * @Date: 2020/11/18 9:31
 */
public class No127_2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord = queue.poll();
                if (changeOneLetterToEndWord(currWord, endWord, wordSet, visited, queue)) {
                    // 没有走step++那一步，所以这里要手动的加一步
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeOneLetterToEndWord(String currWord, String endWord, Set<String> wordSet, Set<String> visited, Queue<String> queue) {

        char[] chars = currWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (c == k) {
                    continue;
                }
                chars[i] = k;
                String word = String.valueOf(chars);
                if (wordSet.contains(word)) {
                    if (!visited.contains(word)) {
                        if (endWord.equals(word)) {
                            return true;
                        }
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            // 恢复
            chars[i] = c;
        }
        return false;

    }


}
