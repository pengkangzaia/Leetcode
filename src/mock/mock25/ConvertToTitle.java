package mock.mock25;

/**
 * @FileName: ConvertToTitle.java
 * @Description: ConvertToTitle.java类说明
 * @Author: admin
 * @Date: 2021/3/10 15:01
 */
public class ConvertToTitle {

    /**
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     */
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber != 0) {
            if (columnNumber % 26 == 0) {
                res.append(letters[25]);
                columnNumber = columnNumber / 26 - 1;
            } else {
                res.append(letters[columnNumber % 26 - 1]);
                columnNumber = columnNumber / 26;
            }
        }
        /*int idx = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
        res.append(letters[idx - 1]);*/
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle solution = new ConvertToTitle();
        for (int i = 1; i < 100; i++) {
            System.out.println(solution.convertToTitle(i));
        }
    }




}
