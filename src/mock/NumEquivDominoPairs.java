package mock;

/**
 * @FileName: NumEquivDominoPairs.java
 * @Description: NumEquivDominoPairs.java类说明
 * @Author: admin
 * @Date: 2021/3/5 11:26
 */
public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] arr = new int[100];
        // 转化为一维计数
        for (int i = 0; i < dominoes.length; i++) {
            int num = dominoes[i][0] < dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1] : dominoes[i][1] * 10 + dominoes[i][0];
            arr[num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            res += (arr[i] * (arr[i] - 1)) / 2;
        }

        return res;

    }


    public static void main(String[] args) {
        // i和j
        // 1*10+2=12
        // 11
        // 22
        int[][] points = {
                {1,2},
                {1,2},
                {1,2},
                {1,1},
                {2,2}
        };
        NumEquivDominoPairs solution = new NumEquivDominoPairs();
        int ans = solution.numEquivDominoPairs(points);
        System.out.println(ans);
    }




}
