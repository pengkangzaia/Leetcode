package MyAnswer.string;

import java.util.LinkedList;
import java.util.List;

public class No17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                char[] chars = mapping[x].toCharArray();
                for (char s : chars) {
                    ans.add(t + s);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "234";
        No17 no17 = new No17();
        List<String> strings = no17.letterCombinations(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
