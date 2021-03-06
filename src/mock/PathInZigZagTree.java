package mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: PathInZigZagTree.java
 * @Description: PathInZigZagTree.java类说明
 * @Author: admin
 * @Date: 2021/3/6 12:37
 */
public class PathInZigZagTree {

    // 计算label对应的row
    // 上一行的值如果没有翻转的话是 label/2
    // 从row-1开始，row-3,row-5 ... 都要进行翻转

    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int row = 0;
        while (Math.pow(2, row) <= label) {
            row++;
        }
        boolean flip = false;
        while (label > 1) {
            if (flip) {
                int num = (int) (Math.pow(2, row - 1) + Math.pow(2, row) - 1 - label);
                res.addFirst(num);
            } else {
                res.addFirst(label);
            }
            label = label / 2;
            row--;
            flip = !flip;
        }
        res.addFirst(1);

        return res;
    }

    public static void main(String[] args) {
        PathInZigZagTree solution = new PathInZigZagTree();
        List<Integer> ans = solution.pathInZigZagTree(26);
        System.out.println(ans);
    }


}
