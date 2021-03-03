package mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: CombinationIterator.java
 * @Description: CombinationIterator.java类说明
 * @Author: admin
 * @Date: 2021/3/1 19:12
 */
public class CombinationIterator {

    /**
     * 一个迭代器类，包括以下内容：
     *
     * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
     * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
     * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
     */

    private char[] chars;

    private List<String> res;

    private int idx = 0;

    public CombinationIterator(String characters, int combinationLength) {
        chars = characters.toCharArray();
        res = new ArrayList<>();
        // 求全排列
        StringBuilder path = new StringBuilder();
        dfs(path, 0, combinationLength);
    }

    private void dfs(StringBuilder path, int currIdx, int length) {
        if (currIdx > chars.length) {
            return;
        }
        if (path.length() == length) {
            res.add(new String(path));
            return;
        }
        for (int i = currIdx; i < chars.length; i++) {
            path.append(chars[i]);
            dfs(path, i + 1, length);
            path.deleteCharAt(path.length() - 1);
        }
    }



    public String next() {
        idx++;
        return res.get(idx - 1);
    }

    public boolean hasNext() {
        return idx <= res.size() - 1;
    }

    public static void main(String[] args) {
        String characters = "abc";
        int combinationLength = 2;
        CombinationIterator iterator = new CombinationIterator(characters, combinationLength);
        System.out.println(iterator.res);
    }


}
