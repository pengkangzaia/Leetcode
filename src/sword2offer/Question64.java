package sword2offer;

public class Question64 {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 1;
        return n;
    }

}
