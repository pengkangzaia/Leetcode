package mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: Generate.java
 * @Description: Generate.java类说明
 * @Author: admin
 * @Date: 2021/3/8 19:47
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        res.add(curr);
        int n = 2;
        while (n <= numRows) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(1);
            for (int i = curr.size() - 1; i >= 1; i--) {
                temp.addFirst(curr.get(i) + curr.get(i - 1));
            }
            temp.addFirst(1);
            res.add(temp);
            curr = temp;
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        Generate g = new Generate();
        List<List<Integer>> ans = g.generate(5);
        System.out.println(ans);
    }


}
