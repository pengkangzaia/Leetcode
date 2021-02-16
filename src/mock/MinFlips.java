package mock;

/**
 * @FileName: MinFlips.java
 * @Description: MinFlips.java类说明
 * @Author: admin
 * @Date: 2021/2/16 21:37
 */
public class MinFlips {


    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitC = (c >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitA = (a >> i) & 1;
            if ((bitA | bitB) != bitC) {
                if (bitC == 0) {
                    res += bitB == 1 ? 1 : 0;
                    res += bitA == 1 ? 1 : 0;
                } else {
                    if (bitB == 0 && bitA == 0) {
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinFlips minFlips = new MinFlips();
        int ans = minFlips.minFlips(2, 6, 5);
        System.out.println(ans);
    }

}
