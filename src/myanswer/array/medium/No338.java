package myanswer.array.medium;

public class No338 {

    public int[] countBits(int num) {
        // 利用 a & (a-1) 把 a 中的最右边的 1 消除的特性
        int[] res = new int[num + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        No338 no338 = new No338();
        int[] ans = no338.countBits(10);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }


}
