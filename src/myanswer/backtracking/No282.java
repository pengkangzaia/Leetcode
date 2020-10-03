package myanswer.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No282.java
 * @Description: 给表达式添加运算符
 * @Author: admin
 * @Date: 2020/9/25 12:00
 */
public class No282 {

    public List<String> addOperators(String num, int target) {
        // 给一个数字字符串，向里面添加二元运算符，使之运算结果成为 target
        List<String> res = new LinkedList<>();
        StringBuilder expression = new StringBuilder();
        traverse(res, expression, num, target, 0);
        return res;
    }

    private void traverse(List<String> res, StringBuilder expression, String num, int target, int index) {

    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        System.out.println(set.contains(1));
    }


}
