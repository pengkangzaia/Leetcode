package myanswer.bit;

/**
 * @FileName: No231.java
 * @Description: 2的幂
 * @Author: admin
 * @Date: 2020/10/22 18:57
 */
public class No231 {

    // 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
        int num = 1;
        int cnt = 0; // 表示移位之后的1后面0的个数。加上1就是32位
        // 只遍历32次
        while (num <= n && cnt < 31) {
            if (num == n) {
                return true;
            }
            num = num << 1;
            cnt++;
        }
        return false;
    }

    public static void main(String[] args) {
        No231 no231 = new No231();
        /*for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + no231.isPowerOfTwo(i));
        }*/
        System.out.println(no231.isPowerOfTwo(1073741825));
    }


}
