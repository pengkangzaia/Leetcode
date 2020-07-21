package sword2offer;

public class Question66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int n = a.length;

        int[] b = new int[n];
        b[0] = 1;
        int temp = 1;

        for (int i = 1; i <= n - 1; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            temp *= a[i + 1];
            // 当前的b[i]乘以temp值
            b[i] *= temp;
        }

        return b;
    }

    public static void main(String[] args) {
        Question66 question66 = new Question66();
        int[] a = {1, 2, 3, 4, 5};
        int[] ans = question66.constructArr(a);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
