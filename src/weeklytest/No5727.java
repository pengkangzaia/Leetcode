package weeklytest;

import java.util.ArrayList;

public class No5727 {

    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        // 模拟遍历
        int currIdx = 0;
        while (list.size() > 1) {
            int removeIdx = (currIdx + k - 1) % (list.size());
            list.remove(removeIdx);
            if (removeIdx == list.size()) {
                currIdx = 0;
            } else {
                currIdx = (removeIdx) % (list.size());
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        No5727 no5727 = new No5727();
        int ans = no5727.findTheWinner(5, 2);
        System.out.println(ans);
    }


}
