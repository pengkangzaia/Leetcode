package myanswer.dfsandbfs;

import java.util.*;

/**
 * @FileName: No127.java
 * @Description: 单词接龙
 * @Author: admin
 * @Date: 2020/10/16 10:03
 */
public class No127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        System.out.println(nextWord);
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        No127 no127 = new No127();
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        int i = no127.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
        System.out.println();
        i = no127.ladderLength1(beginWord, endWord, wordList);
        System.out.println(i);
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 1.数据预处理
        // list转set
        HashSet<String> wordSet = new HashSet<>(wordList);
        // 数据校验
        if(wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 数据预处理
        wordSet.remove(beginWord);

        // 2.根据队列构建图
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // 已经访问过的中间单词
        HashSet<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        // 3.BFS搜索
        int step = 1; // 开始单词也算
        while (!queue.isEmpty()) {
            // 遍历这个队列
            int size = queue.size(); // 要获取一开始的大小，这样可以一层一层遍历
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (changeOneLetterToEnd(currentWord, endWord, wordSet, visitedSet, queue)) {
                    return step + 1; // 最终单词也算
                }
            }
            step++;
        }
        // 搜索中没有找到
        return 0;
    }

    private boolean changeOneLetterToEnd(String beginWord, String endWord, HashSet<String> wordSet, HashSet<String> visitedSet, Queue<String> queue) {
        if (beginWord.equals(endWord)) {
            return true;
        }
        // 字符串转字符数组，便于处理
        char[] currentWord = beginWord.toCharArray();
        // 开始单词转化一个字符
        for (int i = 0; i < currentWord.length; i++) {
            // 缓存当前字符
            char currCharacter = currentWord[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == currCharacter) {
                    continue;
                }
                currentWord[i] = c;
                String midWord = String.valueOf(currentWord);
                // 可以转化为set中的单词
                if (wordSet.contains(midWord)) {
                    if (midWord.equals(endWord)) {
                        return true; // 到达终点
                    }
                    if (!visitedSet.contains(midWord)) {
                        System.out.println(midWord);
                        queue.add(midWord);
                        visitedSet.add(midWord);
                    }
                }
            }
            // 把原来的字符还原
            currentWord[i] = currCharacter;
        }
        // 当前单词的每一个字符都不能转化为最后单词
        // 但是这个遍历过程可能会添加一些中间单词到队列中
        return false;
    }


}
