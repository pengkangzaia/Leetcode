package sword2offer;

public class Question67 {

    public int strToInt(String str) {
        // 这题两个情况要考虑
        // str为空字符串的时候
        // 字符串第一个字符为符号位时
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        int res = 0;
        int flag = 1;
        int begin = 0;
        if (arr[0] == '+') {
            begin = 1;
        } else if (arr[0] == '-') {
            flag = -1;
            begin = 1;
        }
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] <= '9' && arr[i] >= '0') {
                res += Math.pow(10, (arr.length - 1 - i)) * (int) (arr[i] - '0');
            } else {
                return 0;
            }
        }
        return res * flag;
    }

    public static void main(String[] args) {
        Question67 question67 = new Question67();
        int ans = question67.strToInt("-123");
        System.out.println(ans);
    }

}
