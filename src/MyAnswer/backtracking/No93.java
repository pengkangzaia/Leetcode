package MyAnswer.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No93.java
 * @Description: 给一个数字字符串，复原IP地址
 * @Author: admin
 * @Date: 2020/9/24 19:24
 */
public class No93 {

    public List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        // 选3个位置插入
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        LinkedList<Integer> path = new LinkedList<>();
        traverse(nums, path, 0);
        return res;
    }

    public void traverse(int[] nums, LinkedList<Integer> path, int index) {
        if (path.size() == 3) {
            // 判断是否符合IP地址格式
            if(isValid(nums, path)) {
                String s = numsToIP(nums, path);
                res.add(s);
            }
            return;
        }
        // 点（.）不能在最后一个元素之后
        for (int i = index; i < nums.length - 1; i++) {
            path.add(i);
            traverse(nums, path, i + 1);
            path.removeLast();
        }
    }

    public boolean isValid(int[] nums, LinkedList<Integer> path) {

        if (path.size() != 3) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int a = path.get(0);
        int b = path.get(1);
        int c = path.get(2);
        // 1.1.1.1
        // 第一个点的位置记为1（从0开始）
        if (a > 0 && a > b && b > c) {
            int num1 = sum(nums, 0, a);
            int num2 = sum(nums, a, b);
            int num3 = sum(nums, b, c);
            int num4 = sum(nums, c, nums.length);
            if (inRange(num1) && inRange(num2) && inRange(num3) && inRange(num4)) {
                return true;
            }
        }
        return false;


    }

    public int sum(int[] nums, int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum = sum * 10 + nums[i];
        }
        return sum;
    }

    public boolean inRange(int a) {
        return 0 <= a && a <= 255;
    }


}
