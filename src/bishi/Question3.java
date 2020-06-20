package bishi;

import java.util.Scanner;

public class Question3 {

    /**
     * 输入两个int类型的数，返回不相同的bit的个数
     *
     * @param m
     * @param n
     * @return
     */
    public int diffBits(int m, int n) {
        int res = m ^ n;
        int count = 0;
        while (res != 0) {
            res &= (res - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("待比较的两个数为：" + m + " " + n);
        String binaryM = Integer.toBinaryString(m);
        String binaryN = Integer.toBinaryString(n);
        System.out.println("第一个数的二进制表示为：" + binaryM);
        System.out.println("第二个数的二进制表示为：" + binaryN);
        Question3 question3 = new Question3();
        int ans = question3.diffBits(m, n);
        System.out.println("不同的bit位数为：" + ans);
    }

}
