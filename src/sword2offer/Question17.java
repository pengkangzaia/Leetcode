package sword2offer;

public class Question17 {

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        //int[] ans = question17.printNumbers(10);
        //System.out.println(ans.length);
        question17.print1ToMaxOfNDigits(2);
    }

//    public int[] printNumbers(int n) {
//        int size = (int) Math.pow(10, n) - 1;
//        int[] arr = new int[size];
//        for (int i = 0; i <= size - 1; i++) {
//            arr[i] = i + 1;
//        }
//        return arr;
//    }
public void print1ToMaxOfNDigits(int n) {
    if (n <= 0)
        return;
    char[] number = new char[n];
    print1ToMaxOfNDigits(number, 0);
}

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        // digit为number.length时，打印当前字符数组 d = 0处理第0位，d=1处理第1位，d=length到末尾打印
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        // 从左到右打印字符数组，每个字符连起来就是数字
        // 比如{0,2,3,4,5} 表示： 2345
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }



}
