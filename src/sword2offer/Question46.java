package sword2offer;

public class Question46 {

    /*给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
    * */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        return f(s);
    }

    private int f(String s) {
        int i = s.length();
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 1;
        }

        String temp = s.substring(i - 2, i);
        return temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ?
                f(s.substring(0, i - 1)) + f(s.substring(0, i - 2)) :
                f(s.substring(0, i - 1));

    }

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        int ans = question46.translateNum(506);
        System.out.println(ans);
    }

}
