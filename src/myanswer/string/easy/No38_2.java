package myanswer.string.easy;

/**
 * @FileName: No38_2.java
 * @Description: No38外观数列2刷，递归解法
 * @Author: kang.peng
 * @Date: 2020/10/2 14:49
 */
public class No38_2 {

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return say(countAndSay(n-1));
    }

    private String say(String s){
        //记录数值出现的次数
        int count=1;
        //当前的数值
        char num = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<s.length();i++){
            char c = s.charAt(i);
            if(c==num){
                count++;
            }else{
                sb.append(count);
                sb.append(num);
                num = c;
                count=1;
            }
        }
        sb.append(count);
        sb.append(num);
        return sb.toString();
    }

    public static void main(String[] args) {
        No38_2 no38_2 = new No38_2();
        for (int i = 1; i <= 30; i++) {
            String s = no38_2.countAndSay(i);
            System.out.println("n="+i+" "+"res="+s);
        }
    }


}
