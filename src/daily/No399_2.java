package daily;

import java.util.*;

/**
 * @FileName: No399_2.java
 * @Description: 除法求值，参考题解自己实现版
 * @Author: admin
 * @Date: 2021/1/6 18:49
 */
public class No399_2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 字符串转数字
        int countString = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), countString++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), countString++);
            }
        }


        // 获取图中每个点的邻接点
        List<Pair>[] list = new List[countString + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < equations.size(); i++) {
            int indexL = map.get(equations.get(i).get(0));
            int indexR = map.get(equations.get(i).get(1));
            list[indexL].add(new Pair(values[i], indexR));
            list[indexR].add(new Pair(1.0 / values[i], indexL));
        }

        // BFS查找
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                if (map.get(query.get(0)).equals(map.get(query.get(1)))) {
                    res[i] = 1.0;
                } else {
                    // 广度优先搜索查找元素
                    int indexL = map.get(queries.get(i).get(0));
                    int indexR = map.get(queries.get(i).get(1));
                    double[] vars = new double[countString + 1];
                    Arrays.fill(vars, -1.0);
                    vars[indexL] = 1.0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(indexL);
                    while (!queue.isEmpty() && vars[indexR] == -1.0) {
                        Integer poll = queue.poll();
                        for (Pair pair : list[poll]) {
                            if (vars[pair.index] < 0) {
                                vars[pair.index] = pair.value * vars[poll];
                                queue.offer(pair.index);
                            }
                        }
                    }
                    res[i] = vars[indexR];
                }
            }
        }
        return res;

    }





}
