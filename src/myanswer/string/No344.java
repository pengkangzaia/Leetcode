package myanswer.string;

// 反转字符串
public class No344 {

    public void reverseString(char[] s) {
        // <=1
        if (s.length <= 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        char temp;
        while (i <= j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }


    // 20点11分开始 20点15分结束
    public void reverseString1(char[] s) {
        char tem;
        int i = 0;
        int j = s.length;
        while (i < j) {
            tem = s[i];
            s[i] = s[j];
            s[j] = tem;
            i++;
            j--;
        }
    }

}
