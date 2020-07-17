package sword2offer;

public class Question44 {

    public int findNthDigit(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(i);
        }
        return (int) sb.charAt(n) - (int) '0';

    }

    public static void main(String[] args) {
        Question44 question44 = new Question44();
        int ans = question44.findNthDigit(11);
        System.out.println(ans);
    }

}
