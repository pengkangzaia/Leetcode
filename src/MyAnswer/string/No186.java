package MyAnswer.string;

import java.util.Arrays;

public class No186 {

    // 思路：先翻转整个字符串，再翻转每个单词
    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i <= j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        // 对每个单词进行翻转
        i = chars.length - 1;
        j = i;
        while (i>=0){
            while (i>=0 && chars[i] != ' ') i--;
            swap(chars, i+1, j);
            while (i>=0 && chars[i] == ' ') i--;
            j = i;
        }
        return Arrays.toString(chars);
    }

    private void swap(char[] chars, int i, int j) {

        char temp;
        while (i<=j){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        No186 no186 = new No186();
        String ans = no186.reverse("the sky is blue");
        System.out.println(ans);
    }


}
