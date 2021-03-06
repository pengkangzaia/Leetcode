package mock;

/**
 * @FileName: AddDigits.java
 * @Description: AddDigits.java类说明
 * @Author: admin
 * @Date: 2021/3/6 12:26
 */
public class AddDigits {

    public int addDigits(int num) {
        while (num >= 10) {
            num = cal(num);
        }
        return num;
    }

    private int cal(int num) {
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num = num / 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        int ans = solution.addDigits(38);
        System.out.println(ans);
    }


}
