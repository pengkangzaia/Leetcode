package myanswer.string.easy;

/**
 * @FileName: No125.java
 * @Description: 验证回文串
 * @Author: camille
 * @Date: 2020/10/10 22:19
 */
public class No125 {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char a;
        char b;
        while (i <= j) {
            a = s.charAt(i);
            b = s.charAt(j);
            if (!isVaild(a)) {
                i++;
            } else if (!isVaild(b)) {
                j--;
            } else if (equal(a, b)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean equal(char a, char b) {
        if (a >= 48 && a <= 57) {
            return a == b;
        } else {
            return (a == b) || (Math.abs(a - b) == 32);
        }
    }

    private boolean isVaild(char a) {
        return (a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122);
    }

    public static void main(String[] args) {
        No125 no125 = new No125();
        boolean race_a_car = no125.isPalindrome("race a car");
        System.out.println(race_a_car);
    }


}
