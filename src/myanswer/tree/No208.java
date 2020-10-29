package myanswer.tree;

/**
 * @FileName: No208.java
 * @Description: 实现前缀树
 * @Author: camille
 * @Date: 2020/10/28 20:46
 */
public class No208 {

    class Trie {

        // 定义前缀树节点
        class TrieNode {
            private boolean isEnd;
            private TrieNode[] next;

            public TrieNode() {
                isEnd = false;
                next = new TrieNode[26];
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode curr = root;
            for (int i = 0; i < chars.length; i++) {
                int idx = chars[i] - 'a';
                // 可能会重复插入相同前缀的单词，所以需要判断是否为kong
                if (curr.next[idx] == null) {
                    curr.next[idx] = new TrieNode();
                }
                curr = curr.next[idx];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode curr = root;
            for (int i = 0; i < chars.length; i++) {
                int idx = chars[i] - 'a';
                if (curr.next[idx] == null) {
                    return false;
                } else {
                    curr = curr.next[idx];
                }
            }
            return curr.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode curr = root;
            for (int i = 0; i < chars.length; i++) {
                int idx = chars[i] - 'a';
                if (curr.next[idx] == null) {
                    return false;
                } else {
                    curr = curr.next[idx];
                }
            }
            return true;
        }
    }

}
