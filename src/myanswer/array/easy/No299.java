package myanswer.array.easy;

import java.util.HashMap;

public class No299 {
    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0011";
        String ans = getHint(secret,guess);
        System.out.println(ans);
    }

    private static String getHint(String secret, String guess) {


        char[] a = secret.toCharArray();
        char[] b = guess.toCharArray();
        int[] indexs = new int[a.length];
        int bulls = 0;
        int cows = 0;

        HashMap<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i]==b[i]){
                bulls++;
                indexs[i] = 1;
            }else {
                
            }
        }








        return String.valueOf(bulls)+"A"+String.valueOf(cows)+"B";




    }
}
