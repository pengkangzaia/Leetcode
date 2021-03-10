package mock.mock25;

import java.util.*;

/**
 * @FileName: FindItinerary.java
 * @Description: FindItinerary.java类说明
 * @Author: admin
 * @Date: 2021/3/10 15:55
 */
public class FindItinerary {

    public List<String> findItinerary1(List<List<String>> tickets) {
        int n = tickets.size();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>(n);
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            PriorityQueue<String> dests = map.getOrDefault(src, new PriorityQueue<>());
            dests.offer(dest);
            map.put(src, dests);
        }


        List<String> path = new LinkedList<>();
        dfs("JFK", path, map);
        Collections.reverse(path);
        return path;
    }

    private void dfs(String curr, List<String> path, HashMap<String, PriorityQueue<String>> map) {
        while (map.containsKey(curr) || map.get(curr).size() > 0) {
            PriorityQueue<String> strings = map.get(curr);
            String poll = strings.poll();
            dfs(poll, path, map);
        }
        path.add(curr);
    }





}
