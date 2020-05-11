package sword2offer;

public class Question14_2 {

    public static void main(String[] args) {
        Question14_2 question14_2 = new Question14_2();
        int ans = question14_2.cuttingRope(127);
        System.out.println(ans);
    }

    public int cuttingRope(int n) {
        // 优先把切割长度为 3 的绳子

        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        long ans = 1;
        while (n >= 5) {
            ans = ans * 3;
            ans = ans % 1000000007;
            n = n - 3;
        }

        return (int) ((ans * n) % 1000000007);
    }

}
