package myanswer.string.medium;

/**
 * @FileName: No1754.java
 * @Description: 构造字典序最大的合并字符串
 * @Author: admin
 * @Date: 2021/2/9 10:56
 */
public class No1754 {

    // 贪心，优先选择两个字符串中（从i开始的字符串和j开始的字符串）字典序大的那一个
    public String largestMerge(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            // 如果到了字符串尽头，空字符串比任何字符串都小，所以逻辑也成立
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

}
