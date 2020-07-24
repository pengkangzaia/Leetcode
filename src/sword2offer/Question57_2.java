package sword2offer;

import java.util.ArrayList;

public class Question57_2 {

    // 和为s的l连续正数序列
    // 滑动窗口解决
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        // 滑动窗口左开右闭
        int i = 1;
        int j = 1; //初始的滑动窗口大小为0
        int tem = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (i <= sum/2) {
            if (tem < sum) {
                // 左移滑动窗口
                tem += j;
                j++;
            } else if (tem > sum) {
                tem -= i;
                i++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int m = i; m < j; m++) {
                    list.add(m);
                }
                res.add(list);
                // 改变滑动窗口
                tem -= i;
                i++;
            }
        }
        return res;
    }

}
