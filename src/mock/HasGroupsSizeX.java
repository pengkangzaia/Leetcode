package mock;

import java.util.HashMap;

/**
 * @FileName: HasGroupsSizeX.java
 * @Description: HasGroupsSizeX.java类说明
 * @Author: admin
 * @Date: 2021/3/9 15:33
 */
public class HasGroupsSizeX {

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * 示例 2：
     * <p>
     * 输入：[1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * 示例 3：
     * <p>
     * 输入：[1]
     * 输出：false
     * 解释：没有满足要求的分组。
     * 示例 4：
     * <p>
     * 输入：[1,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]
     * 示例 5：
     * <p>
     * 输入：[1,1,2,2,2,2]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= deck.length <= 10000
     * 0 <= deck[i] < 10000
     */

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < deck.length; i++) {
            int currCount = map.getOrDefault(deck[i], 0) + 1;
            map.put(deck[i], currCount);
        }
        for (Integer count : map.values()) {
            minCount = Math.min(minCount, count);
        }
        if (minCount < 2 || deck.length < 2) {
            return false;
        }
        // 求count的最大公约数，看看这里能不能优化一下？
        int maxValue = cal(map.get(deck[0]), map.get(deck[1]));
        for (Integer value : map.values()) {
            maxValue = cal(maxValue, value);
        }
        return maxValue >= 2;
    }

    private int cal(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        HasGroupsSizeX solution = new HasGroupsSizeX();
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        boolean ans = solution.hasGroupsSizeX(deck);
        System.out.println(ans);
    }


}
