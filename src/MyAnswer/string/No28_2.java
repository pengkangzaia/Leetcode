/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package MyAnswer.string;

/**
 * @FileName: No28_2.java
 * @Description: 实现 strStr()二刷
 * @Author: kang.peng
 * @Date: 2020/10/1 14:22
 */
public class No28_2 {

    public int strStr(String haystack, String needle) {
        // 双指针,一个表示当前在原字符串中的位置，另一个表示相同字符的个数
        if (needle.length() == 0) { return 0; }
        if (haystack.length() < needle.length()) { return -1; }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 判断后续
                int cur = i;
                int j = 0;
                while (j < needle.length()) {
                    if (cur < haystack.length() && haystack.charAt(cur) == needle.charAt(j)) {
                        cur++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            // 否则，i++继续
        }
        return -1;
    }

    public static void main(String[] args) {
        No28_2 no28_2 = new No28_2();
        int res = no28_2.strStr("aaaaa", "bba");
        System.out.println(res);
    }


}
