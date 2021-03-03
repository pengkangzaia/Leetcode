package myanswer.math;

/**
 * @FileName: No476.java
 * @Description: 数字的补数
 * @Author: camille
 * @Date: 2021/3/1 23:07
 */
public class No476 {

    public int findComplement(int num) {
        int start = 31;
        // 找到最左边的1
        for (int i = 31; i >= 0; i--) {
            if(((num >> i) & 1) == 1) {
                start = i;
                break;
            }
        }

        // 从最左边的1开始翻转
        for (int i = start; i >= 0; i--) {
            num ^= (1 << i);
        }

        return num;

    }

    public static void main(String[] args) {
        /*No476 no476 = new No476();
        int ans = no476.findComplement(5);
        System.out.println(ans);*/
        /*Integer integer = Integer.valueOf("0041463");
        System.out.println(integer);*/
        /*for (int i = 10; i <= Math.pow(10, 9); i = i + 10) {
            System.out.println((i & (i - 1)) == 0);
        }*/
        for (int i = 0; i < 32; i++) {
            System.out.println(1 << i);
        }
    }


}
