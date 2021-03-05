package mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: CombinationIterator_2.java
 * @Description: CombinationIterator_2.java类说明
 * @Author: admin
 * @Date: 2021/3/5 11:33
 */
public class CombinationIterator_2 {

    // 求全排列
    ArrayList<String> list;
    int idx;

    public CombinationIterator_2(String characters, int combinationLength) {
        list = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        char[] chars = characters.toCharArray();
        dfs(path, chars, 0, combinationLength);
        idx = 0;
    }

    private void dfs(StringBuilder path, char[] chars, int idx, int n) {
        if (path.length() == n) {
            list.add(new String(path));
            return;
        }
        for (int i = idx; i < chars.length; i++) {
            path.append(chars[i]);
            dfs(path, chars, i + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public String next() {
        String s = list.get(idx);
        idx++;
        return s;
    }

    public boolean hasNext() {
        return idx <= list.size() - 1;
    }


}
