package MyAnswer.math;

public class No7 {

    public static int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int tem = res * 10 + x % 10;
            x /= 10;
            if (tem / 10 != res) {
                return 0;
            } else {
                res = tem;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int ans = reverse(-132);
        System.out.println(ans);
        System.out.println(reverse(132));
    }

}
