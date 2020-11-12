package myanswer.string.medium;

/**
 * @FileName: No208.java
 * @Description: 实现前缀树
 * @Author: admin
 * @Date: 2020/11/12 16:27
 */
public class No208 {

    static class Trie {
        // 内部类,表示树的节点
        class TrieNode {
            TrieNode[] subNodes = new TrieNode[26];
            boolean isEnd = false;
        }

        // 前缀树中保留树的头节点
        private TrieNode head;


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode curr = head;
            for (int i = 0; i < chars.length; i++) {
                // 如果存在，就不需要新建节点，可以用原来的
                if (curr.subNodes[chars[i] - 'a'] == null) {
                    curr.subNodes[chars[i] - 'a'] = new TrieNode();
                }
                curr = curr.subNodes[chars[i] - 'a'];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            char[] chars = word.toCharArray();
            TrieNode curr = head;
            for (int i = 0; i < chars.length; i++) {
                if (curr.subNodes[chars[i] - 'a'] == null) {
                    return false;
                }
                curr = curr.subNodes[chars[i] - 'a'];
            }
            return curr.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            char[] chars = prefix.toCharArray();
            TrieNode curr = head;
            for (int i = 0; i < chars.length; i++) {
                if (curr.subNodes[chars[i] - 'a'] == null) {
                    return false;
                }
                curr = curr.subNodes[chars[i] - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        boolean param_2 = obj.search("app");
        boolean param_3 = obj.search("apps");
        System.out.println(param_2);
        System.out.println(param_3);
        boolean param_4 = obj.startsWith("aa");
        System.out.println(param_4);
    }


}
