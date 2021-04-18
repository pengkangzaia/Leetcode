package weeklytest;

public class No5737 {

    public int getXORSum(int[] arr1, int[] arr2) {
        // 先计算数组2的异或结果
        int num = 0;
        for (int i = 0; i < arr2.length; i++) {
            num = num ^ arr2[i];
        }
        if (num == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            res = res ^ (arr1[i] & num);
        }
        return res;
    }




}
