package myanswer.array.easy;

import java.util.HashSet;
import java.util.Set;

public class No217 {

    public static void main(String[] args) {
        int[] nums = {};
        boolean ans = containsDuplicate(nums);
        System.out.println(ans);
    }


    public static boolean containsDuplicate(int[] nums) {
        //构建hashmap，判断元素是否存在于哈希表中
        //如果存在，返回false
        //如果不存在，加入到hashmap中
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }else {
                set.add(num);
            }
        }
        return false;
    }
}
