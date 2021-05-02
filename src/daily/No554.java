package daily;

import java.util.HashMap;
import java.util.List;

public class No554 {

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        for (List<Integer> row : wall) {
            int currIdx = 0;
            int m = row.size();
            for (int i = 0; i < m - 1; i++) {
                int currLen = row.get(i);
                currIdx += currLen;
                map.put(currIdx, map.getOrDefault(currIdx, 0) + 1);
            }
        }

        int res = n;
        for (Integer key : map.keySet()) {
            Integer integer = map.get(key);
            res = Math.min(res, n - integer);
        }
        return res;
    }


}
