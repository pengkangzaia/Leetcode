package myanswer.dynamicprogramming;

/**
 * @FileName: No887.java
 * @Description: 鸡蛋掉落
 * @Author: admin
 * @Date: 2020/11/12 10:02
 */
public class No887 {

    private Integer[][] memo = null;

    public int superEggDrop(int K, int N) {
        memo = new Integer[K+1][N+1];
        return dp(K, N);
    }

    private int dp(int k, int n) {
        if (k == 1) {return n;}
        if (n <= 0) {return 0;}
        // 利用备忘录
        if (memo[k][n] != null) {return memo[k][n];}
        int res = Integer.MAX_VALUE;
        // 方法1
        /*for (int i = 1; i <= n+1; i++) {
            int eggBroken = dp(k-1, i-1); // i-1层需要搜索
            int eggNotBroken = dp(k, n-i); // n-i层需要搜索
            res = Math.min(res, Math.max(eggBroken, eggNotBroken) + 1);
        }*/
        // 方法2
        int lo=1,hi =n;
        while(lo<=hi){
            int mid =(lo+hi)/2;
            int eggBreak = dp(k-1,mid-1);
            int eggUnBreak = dp(k,n-mid);
            // 最坏情况
            if(eggBreak>eggUnBreak){
                hi = mid-1;
                // 最少步骤
                res = Math.min(res,eggBreak+1);
            }else{
                lo = mid+1;
                res = Math.min(res,eggUnBreak+1);
            }
        }
        memo[k][n] = res;
        return res;
    }

    public static void main(String[] args) {
        No887 no887 = new No887();
        int ans = no887.superEggDrop(2, 200);
        System.out.println(ans);
    }
}
