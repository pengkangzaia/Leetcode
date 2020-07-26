package MyAnswer.string;

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

}
