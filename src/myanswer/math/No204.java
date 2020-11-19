package myanswer.math;

/**
 * @FileName: No204.java
 * @Description: 计算质数
 * @Author: admin
 * @Date: 2020/11/19 9:48
 */
public class No204 {
    // 统计所有小于非负整数 n 的质数的数量
    // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数。
    // 最小的质数是2，它也是唯一的偶数质数。最前面的质数依次排列为：2，3，5，7，11等。比1大但不是质数的数称为合数

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int res = 0;
        // dp[i]表示小于第i个数的质数的数量
        for (int i = 3; i <= n; i++) {
            // 如果i-1是质数就可以
            if (prime(i-1)) {
                res++;
            }
        }
        return res;
    }

    private boolean prime(int num) {
        // 判断一个数是不是质数
        if (num == 2) {
            return true;
        }
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        No204 no204 = new No204();
        int ans = no204.countPrimes1(10);
        System.out.println(ans);
    }


    // 如果我们在进行顺序遍历时，每取得一个数（排除0、1），
    // 如果将它所有的倍数（排除0、1、本身）都清除，那么，剩下的数是不是必为素数？
    public int countPrimes1(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!visited[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    visited[j] = true;
                }
            }
        }
        return count;
    }




}
