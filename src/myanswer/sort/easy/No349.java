package myanswer.sort.easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No349 {
    public static void main(String[] args) {
        /*int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};*/
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};


        int[] ans = intersection(nums1,nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> a = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        HashSet<Integer> hashSet = new HashSet(list1);
        for (int i : nums2) {
            if(hashSet.contains(i)){
                a.add(i);
            }
        }

        Integer[] temp = a.toArray(new Integer[]{});
        int[] intArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            intArray[i] = temp[i].intValue();
        }

        return intArray;
    }

}
