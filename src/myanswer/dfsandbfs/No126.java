package myanswer.dfsandbfs;

import java.util.*;

/**
 * @FileName: No26.java
 * @Description: 单词接龙2
 * @Author: admin
 * @Date: 2020/10/20 15:10
 */
public class No126 {

    // BFS返回的一定是最短路径，现在只需要找到路径即可
    // 优化思路：实际上用的是DFS，所以每一个节点第一次出现了，就记录他的离开始节点的长度。
    // 如果他在第k层出现，但在之前1-（k-1）层出现过，就不用再计算了。因为长度肯定会更长。

    private List<List<String>> res = new LinkedList<>();

    private int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // wordList转为set，便于判断是否在字典中
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new LinkedList<>();
        }
        wordSet.remove(beginWord);

        // 构建BFS需要的数据结构
        HashMap<String, Set<String>> graph = buildGraph(beginWord, wordSet);
        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);

        traverse(beginWord, endWord, wordSet, path, graph);

        // 过滤res出最小的路径
        List<List<String>> ans = new LinkedList<>();
        for (List<String> list : res) {
            min = Math.min(min, list.size());
        }
        for (List<String> re : res) {
            if (re.size() == min) {
                ans.add(re);
            }
        }
        return ans;
    }

    private HashMap<String, Set<String>> buildGraph(String beginWord, HashSet<String> wordSet) {
        HashMap<String, Set<String>> graph = new HashMap<>();
        // beginWord也是图的一部分
        wordSet.add(beginWord);
        for (String word : wordSet) {
            char[] curr = word.toCharArray();
            for (int i = 0; i < curr.length; i++) {
                char temp = curr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    // 等于原来的字符，不是等于当前字符
                    if (temp == j) {
                        continue;
                    }
                    curr[i] = j;
                    String currWord = String.valueOf(curr);
                    if (wordSet.contains(currWord)) {
                        Set<String> neighbor = new HashSet<>();
                        if (graph.get(word) == null) {
                            neighbor.add(currWord);
                            graph.put(word, neighbor);
                        } else {
                            neighbor = graph.get(word);
                            neighbor.add(currWord);
                            graph.put(word, neighbor);
                        }
                    }
                }
                curr[i] = temp;
            }
        }
        return graph;
    }

    private void traverse(String beginWord, String endWord, HashSet<String> wordSet, LinkedList<String> path, HashMap<String, Set<String>> graph) {
        if (path.size() > min) {
            return; // 剪枝，如果超过了当前路径的最小长度就不需要再查找了
        }

        if (beginWord.equals(endWord)) {
            res.add(new LinkedList<>(path));
            min = Math.min(min, path.size());
            return;
        }
        // BFS正式开始
        // 记录BFS这一层的个数，只遍历这一层。后面加的不需要
        Set<String> neighbors = graph.get(beginWord);
        if (neighbors != null) {
            for (String neighbor : neighbors) {
                if (valid(neighbor, endWord, wordSet, path)) {
                    path.add(neighbor);
                    traverse(neighbor, endWord, wordSet, path, graph);
                    path.removeLast();
                }
            }
        }
    }

    private boolean valid(String beginWord, String endWord, HashSet<String> wordSet, LinkedList<String> path) {
        if (beginWord.equals(endWord)) {
            return true;
        }
        if (wordSet.contains(beginWord) && !path.contains(beginWord)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String[] words = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};
        No126 no126 = new No126();
        List<String> wordList = new LinkedList<>(Arrays.asList(words));
        String beginWord = "cet";
        String endWord = "ism";
        List<List<String>> ladders = no126.findLadders(beginWord, endWord, wordList);
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }


}
