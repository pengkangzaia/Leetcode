package myanswer.sort.easy;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No242 {
    public static void main(String[] args) {
        String s = "";
        String t = "";
        boolean flag = isAnagram(s,t);
        System.out.println(flag);
    }

    private static boolean isAnagram(String s, String t) {
        if(s!=null&&s.length()>0&&t!=null&&t.length()>0&&s.length()==t.length()) {
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            Arrays.sort(schars);
            Arrays.sort(tchars);
            boolean flag = schars[0] == tchars[0];
            for (int i = 0; i < schars.length; i++) {
                flag = flag && (schars[i] == tchars[i]);
            }
            return flag;
        }
        else if (s.length()==0&&t.length()==0)
            return true;
        else
            return false;
    }

    // AC 2020年11月12日19点41分
    public boolean isAnagram1(String s, String t) {
        if(s.length() == t.length()) {
            if (s.length() == 0) {
                return true;
            }
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            boolean flag = true;
            for (int i = 0; i < chars1.length; i++) {
                flag = flag && (chars1[i] == chars2[i]);
            }
            return flag;
        }
        return false;
    }
}

