package mock;

/**
 * @FileName: ReverseOnlyLetters.java
 * @Description: ReverseOnlyLetters.java类说明
 * @Author: admin
 * @Date: 2021/2/11 16:55
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            // 有大小写之分
            if (!((chars[left] <= 'z' && chars[left] >= 'a') || (chars[left] <= 'Z' && chars[left] >= 'A'))) {
                left++;
            } else if (!((chars[right] <= 'z' && chars[right] >= 'a') || (chars[right] <= 'Z' && chars[right] >= 'A'))) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters solution = new ReverseOnlyLetters();
        String s = solution.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(s);
    }


}
