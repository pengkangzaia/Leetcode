package MyAnswer.dynamicprogramming;

public class No70 {

    // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    // 注意：给定 n 是一个正整数。
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else {
            int curr = 2;
            int sum = 0;
            int currMinusOne = 1;
            int currMinusTwo = 1;
            while (curr <= n) {
                sum = currMinusOne + currMinusTwo;
                currMinusOne = currMinusTwo;
                currMinusTwo = sum;
                curr++;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        No70 no70 = new No70();
        int ans = no70.climbStairs(3);
        System.out.println(ans);
    }


}
