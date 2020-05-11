package sword2offer;

public class Question16 {

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        double ans = question16.myPow(2.1, 3);
        System.out.println(ans);
    }

    public double myPow(double base, int exponent) {
        long temp = (long) exponent;
        if (temp == 0)
            return 1;
        if (temp == 1)
            return base;
        boolean isNegative = false;
        if (temp < 0) {
            temp = -temp;
            isNegative = true;
        }
        double pow = myPow(base * base, (int) (temp / 2));
        if (temp % 2 != 0)
            pow = (pow * base);
        return isNegative ? 1 / pow : pow;
    }
}
