package mock;

/**
 * @FileName: MaximumGain.java
 * @Description: MaximumGain.java类说明
 * @Author: admin
 * @Date: 2021/3/5 11:40
 */
public class MaximumGain {

    /**
     * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
     * <p>
     * 删除子字符串 "ab" 并得到 x 分。
     * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
     * 删除子字符串"ba" 并得到 y 分。
     * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
     * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
     */


    // abaab
    // 每一个b最多只能被用一次，要么被x用，要么被y用
    public int maximumGain(String s, int x, int y) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int score = 0;
        char[] chars = s.toCharArray();
        String pattern = x >= y ? "ab" : "ba";
        int idx;
        while ((idx = exist(chars, pattern)) != -1) {
            remove(chars, idx);
            score += "ab".equals(pattern) ? x : y;
        }
        pattern = x >= y ? "ba" : "ab";
        while ((idx = exist(chars, pattern)) != -1) {
            remove(chars, idx);
            score += "ba".equals(pattern) ? y : x;
        }
        return score;
    }

    // 删除两个字母
    private void remove(char[] chars, int idx) {
        for (int i = idx; i < chars.length - 2; i++) {
            chars[i] = chars[i + 2];
        }
        for (int i = chars.length - 2; i < chars.length; i++) {
            chars[i] = '#';
        }
    }

    // 判断是否存在
    private int exist(char[] chars, String pattern) {
        for (int i = 0; i < chars.length - pattern.length(); i++) {
            if (chars[i] == pattern.charAt(0) && chars[i + 1] == pattern.charAt(1)) {
                return i;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        MaximumGain solution = new MaximumGain();
        int ans = solution.maximumGain("cdbcbbaaabab", 4, 5);
        String s = "feg";
        // 结束条件：长度小于2，没有a或者没有b
        // 跳出条件：没有ab或者没有ba
        //
        // cdbcbbaaa b
        // cdbcb aa b
        // cdbc a b
        // cdbc
        System.out.println(ans);
    }


}
