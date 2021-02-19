//package weeklytest.single;
//
//import java.util.*;
//
///**
// * @FileName: No1743.java
// * @Description: 从相邻元素对还原数组
// * @Author: camille
// * @Date: 2021/2/6 11:33
// */
//public class No1743 {
//
//
//    // 回溯？不行啊！！！
//    public int[] restoreArray(int[][] adjacentPairs) {
//        // list里面存另外一个元素
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < adjacentPairs.length; i++) {
//            List<Integer> list =  map.getOrDefault(adjacentPairs[i][0], new LinkedList<>());
//            list.add(adjacentPairs[i][1]);
//            map.put(adjacentPairs[i][0], list);
//
//            list = map.getOrDefault(adjacentPairs[i][1], new LinkedList<>());
//            list.add(adjacentPairs[i][0]);
//            map.put(adjacentPairs[i][1], list);
//        }
//        int start = 0;
//        for (Integer key : map.keySet()) {
//            if (map.get(key).size() == 1) {
//                start = key;
//                break;
//            }
//        }
//        HashSet<Integer> set = new HashSet<>();
//        set.add(start);
//
//        // 我们知道了start的值，那就从start开始
//        int[] res = new int[adjacentPairs.length + 1];
//        int index = 0;
//        res[index] = start;
//
//
//
//
//        return pathToRes(path);
//    }
//
//    private int[] pathToRes(List<int[]> path) {
//        int[] res = new int[path.size() + 1];
//        int index = 0;
//        for (int[] num : path) {
//            res[index++] = num[0];
//        }
//        res[index] = path.get(path.size() - 1)[1];
//        return res;
//    }
//
//    private void dfs(int[][] adjacentPairs, List<int[]> res, List<int[]> path, boolean[] visited) {
//        if (path.size() == adjacentPairs.length) {
//            res = new LinkedList<>(path);
//            return;
//        }
//        int[] preArray = path.get(path.size() - 1);
//        for (int i = 0; i < adjacentPairs.length; i++) {
//            if (!visited[i]) {
//                if (preArray[1] == adjacentPairs[i][0]) {
//                    visited[i] = true;
//                    path.add(adjacentPairs[i]);
//                    dfs(adjacentPairs,res, path, visited);
//                    path.remove(path.size() - 1);
//                    visited[i] = false;
//                } else if (preArray[1] == adjacentPairs[i][1]) {
//                    visited[i] = true;
//                    swap(adjacentPairs[i]);
//                    path.add(adjacentPairs[i]);
//                    dfs(adjacentPairs,res, path, visited);
//                    path.remove(path.size() - 1);
//                    swap(adjacentPairs[i]);
//                    visited[i] = false;
//                }
//            }
//        }
//    }
//
//    private void swap(int[] adjacentPair) {
//        int temp = adjacentPair[0];
//        adjacentPair[0] = adjacentPair[1];
//        adjacentPair[1] = temp;
//    }
//
//    public static void main(String[] args) {
//        No1743 no1743 = new No1743();
//        int[][] nums = {{2, 1}, {3, 4}, {3, 2}};
//        int[] ans = no1743.restoreArray(nums);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(ans[i]);
//        }
//    }
//
//
//
//
//
//}
