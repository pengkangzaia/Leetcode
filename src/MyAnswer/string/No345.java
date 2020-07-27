package MyAnswer.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class No345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        while (i <= j) {
            while (i<=j && !set.contains(chars[i])) {
                i++;
            }
            while (i<=j && !set.contains(chars[j])) {
                j--;
            }
            // 注意这里要判断是否结束循环
            // 不然会进行不必要的交换
            if (i > j) {
                break;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No345 no345 = new No345();
        String ans = no345.reverseVowels("leetcode");
        System.out.println(ans);
    }

}
