package sword2offer;

public class Question65 {
    // a 和 b 相加
    public int add(int a, int b) {
        int c = 0;
        // 当进位为0时，跳出循环
        while (b != 0) {
            c = (a & b) << 1; // 是否进位
            a = a ^ b; // 二进制加法
            b = c;     // 把进位赋值给b
        }
        // 循环计算的是进位值加上无进位和
        return a;
    }

    public static void main(String[] args) {
        Question65 question65 = new Question65();
        int ans = question65.add(15, 2);
        System.out.println(ans);
    }

}
