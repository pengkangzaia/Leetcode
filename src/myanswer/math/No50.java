package myanswer.math;

/**
 * @FileName: No50.java
 * @Description: pow(x,n)
 * @Author: camille
 * @Date: 2020/11/21 12:51
 */
public class No50 {

    // 答案
    public double myPow(double x, int n) {
        long N = n; // 可能会有溢出，先转化为long类型
        return n < 0 ? 1 / pow(x, -N) : pow(x, N);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        // 下面这段可以优化，pow(x,n/2)赋值给一个变量，
        // 这样我们就不需要重复计算接近4遍了
/*
        if (n % 2 == 0) {
            return pow(x, n / 2) * pow(x, n / 2);
        } else {
            return pow(x, n / 2 + 1) * pow(x, n / 2);
        }*/
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static void main(String[] args) {
        No50 no50 = new No50();
        double ans = no50.pow(2, 24);
        System.out.println(ans);
    }


}
