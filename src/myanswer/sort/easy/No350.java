package myanswer.sort.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class No350 {
    public static void main(String[] args) {
        //[61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81]
        //[5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48]
        //int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        //int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        //[5,4,57,79,7,89,88,45,34,92,38,85,6,0,77,44,61]


        int[] ans = intersect(nums1,nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        //HashMap记录重复次数
        HashMap<Integer,Integer> hashMap1 = new HashMap<>();
        HashMap<Integer,Integer> hashMap2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if(hashMap1.containsKey(nums1[i])){
                Integer value = hashMap1.get(nums1[i]) + 1;
                hashMap1.put(nums1[i],value);
            }else {
                hashMap1.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(hashMap2.containsKey(nums2[i])){
                Integer value = hashMap2.get(nums2[i]) + 1;
                hashMap2.put(nums2[i],value);
            }else {
                hashMap2.put(nums2[i],1);
            }
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        //遍历HashMap1和HashMap2查询结果
        for (Integer key1 : hashMap1.keySet()) {
            for (Integer key2 : hashMap2.keySet()) {
                if(key1.equals(key2)){
                    Integer value1 = hashMap1.get(key1);
                    Integer value2 = hashMap2.get(key2);
                    if(value1>value2){
                        hashMap.put(key1,value2);
                    }else {
                        hashMap.put(key1,value1);
                    }
                }
            }
        }

        ArrayList<Integer> aList = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            int value = hashMap.get(key);
            while (value!=0){
                aList.add(key);
                value--;
            }
        }
        int[] ans = new int[aList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = aList.get(i);
        }

        return ans;

    }
}
