package myanswer.sort.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No179 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        String ans = largestNumber(nums);
        System.out.println(ans);
    }

    private static String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        String ans = "";
        Collections.sort(list,new LargerNumberComparator());
        //注意特殊条件，有多个0时，转为一个0字符串
        if(list.get(list.size()-1).equals("0")){
            return "0";
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += list.get(i);
        }

        return ans;
    }



    private static class LargerNumberComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            String ab = a+b;
            String ba = b+a;
            return ab.compareTo(ba);
        }
    }
}


