package sword2offer;

import bishi.Question4;

public class Question64 {

    public int sumNums(int n) {
        // 这里不能是 ==，否则后面的条件会被短路不被执行
        boolean x = (n > 1) && (n += sumNums(n - 1)) > 1;
        return n;
    }

    public static void main(String[] args) {
//        Question64 question64 = new Question64();
//        int ans = question64.sumNums(3);
//        System.out.println(ans);
        String s = " ";
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        System.out.println(res.toString().trim()); // 转化为字符串，删除尾部空格，并
    }

}
