package mock;

/**
 * @FileName: CountPairs.java
 * @Description: CountPairs.java类说明
 * @Author: admin
 * @Date: 2021/3/1 14:14
 */
public class CountPairs {

    // 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
    //
    //你可以搭配 任意 两道餐品做一顿大餐。
    //
    //给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i道餐品的美味程度，
    // 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
    //
    //注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。

    // 暴力解法超时
    public int countPairs(int[] deliciousness) {
        int res = 0;
        int modNum = (int) (Math.pow(10, 9) + 7);
        // 排序？求和？
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if (powOfTwo(deliciousness[i] + deliciousness[j])) {
                    res++;
                    res %= modNum;
                }
            }
        }
        return res;
    }


    // 考虑HashMap


    private boolean powOfTwo(int num) {
        if (num <= 0) {
            return false;
        }
        return (num & (num - 1)) == 0;
    }

}
