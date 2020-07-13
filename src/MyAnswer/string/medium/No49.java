package MyAnswer.string.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            // 这里不能用 toString，返回的是数组的地址，而不是字符串
            // 用 Arrays.toString
            String temps = Arrays.toString(temp);

            if (map.containsKey(temps)) {
                List<String> currlist = map.get(temps);
                currlist.add(strs[i]);
            } else {
                List<String> newlist = new LinkedList<>();
                newlist.add(strs[i]);
                map.put(temps,newlist);
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;

    }

    public static void main(String[] args) {
        No49 no49 = new No49();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = no49.groupAnagrams(strings);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
