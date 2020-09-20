/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package weeklytest;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No5519.java
 * @Description: No5519.java类说明
 * @Author: kang.peng
 * @Date: 2020/9/20 11:27
 */
public class No5519 {

    public static String reorderSpaces(String text) {
        // 记录空格数，单词数
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') { spaceCount++; }
        }

        StringBuilder res = new StringBuilder();
        if (wordCount == 1) {
            res.append(words[0]);
            res.append(getString(spaceCount));
        } else {
            res.append(words[0]);
            int space = spaceCount / (wordCount - 1);
            int left = spaceCount % (wordCount - 1);
            for (int i = 1; i < wordCount; i++) {
                res.append(getString(space));
                res.append(words[i]);
            }
            res.append(getString(left));
        }
        return res.toString();
    }

    public static String getString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            sb.append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        String s = reorderSpaces(" this  is a   sentence");
        System.out.println(s);

/*        String s = "  this   is  a sentence ";
        String[] res = s.trim().split("\\s");
        for (String re : res) {
            System.out.println(re);
        }*/

    }


}
