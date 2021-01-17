package daily;

import java.security.SecureRandom;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    private static final char[] CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static String getRandomPassword(int s, int e) {
        SecureRandom random = new SecureRandom();
        StringBuilder res = new StringBuilder();
        int passwordLength = s + random.nextInt(e - s + 1);
        int[] passwordIndex = new int[passwordLength];
        for (int i = 0; i < passwordIndex.length; i++) {
            passwordIndex[i] = random.nextInt(CHARS.length);
            res.append(CHARS[passwordIndex[i]]);
        }
        return checkPassword(res.toString()) ? res.toString() : getRandomPassword(s, e);
    }

    private static boolean checkPassword(String password) {
        if (password == null || "".equals(password)) {
            return false;
        }
        char[] chars = password.toCharArray();
        int digit = 0, letter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                letter++;
            }
            if (Character.isDigit(chars[i])) {
                digit++;
            }
        }
        return digit > 0 && letter > 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            String randomPassword = getRandomPassword(8, 20);
            System.out.println(randomPassword);
        }
    }
}
