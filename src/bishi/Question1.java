package bishi;

public class Question1 {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        int num = 100;
        System.out.println("原数字为：" + num);
        String ans = question1.inverseInteger(num);
        System.out.println("逆序后输出字符串为：" + ans);
    }

    /**
     * 输入一个整数，以字符串的形式逆序输出
     *
     * @param num 整数
     * @return 逆序字符串
     */
    public String inverseInteger(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
