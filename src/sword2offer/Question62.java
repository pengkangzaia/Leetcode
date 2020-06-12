package sword2offer;

import java.util.LinkedList;

public class Question62 {

    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m -1) % n;
            list.remove(index);
            n--;
        }
        return list.peekFirst();
    }

    public static void main(String[] args) {
        Question62 question62 = new Question62();
        int ans = question62.lastRemaining(5, 3);
        System.out.println(ans);
    }

}
