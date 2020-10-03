package myanswer.string;

public class No168 {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            String ans = convertToTitle(i);
            System.out.println("当前为第" + i + "个数" + ans);
        }
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--; // n = 26时 n/=26 = 1，但是应该是等于0的。
            // 1 到 26 的映射 变为 0 到 25 的映射
            int a = n % 26;
            char temp = (char) ('A' + a);
            sb.append(temp);
            n /= 26;
        }
        return sb.reverse().toString();

    }


}
