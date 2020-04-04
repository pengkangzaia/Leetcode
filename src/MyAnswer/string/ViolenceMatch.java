package MyAnswer.string;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "CABABCDEEE";
        String str2 = "ABCD";

        int i = violenceMatch(str1,str2);
        System.out.println(i);
    }

    private static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i<s1.length && j<s2.length){
            if(s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;  //回溯
            }
        }
        if (j==s2.length){
            return i - j;
        }else return -1;

    }


}
