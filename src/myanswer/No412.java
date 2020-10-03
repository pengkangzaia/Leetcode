/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No412.java
 * @Description: No412.java类说明
 * @Author: kang.peng
 * @Date: 2020/9/13 16:14
 */
public class No412 {


    public static void main(String[] args) {
        List<String> ans = fizzBuzz(100);
        System.out.println(ans);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

}
