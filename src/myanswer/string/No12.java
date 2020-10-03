package myanswer.string;

public class No12 {

    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int a = num / nums[i];
            num = num - a * nums[i];
            while (a > 0) {
                sb.append(strings[i]);
                a--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No12 no12 = new No12();
        String ans = no12.intToRoman(1994);
        System.out.println(ans);
    }

}
