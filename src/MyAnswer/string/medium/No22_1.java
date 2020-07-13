package MyAnswer.string.medium;

import java.util.LinkedList;
import java.util.List;

public class No22_1 {

    private List<String> list = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        dfs(list, "", left, right, n);
        return list;
    }

    public void dfs(List<String> list, String s, int left, int right, int n) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left >= right) {
            if (left < n) {
                dfs(list,s + '(', left + 1, right, n);
            }
            if (right < n) {
                dfs(list,s + ')', left, right + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        No22_1 no22_1 = new No22_1();
        List<String> list = no22_1.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
