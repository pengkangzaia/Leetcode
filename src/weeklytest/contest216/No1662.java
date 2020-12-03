package weeklytest.contest216;

/**
 * @FileName: No1662.java
 * @Description: No1662.java类说明
 * @Author: admin
 * @Date: 2020/11/25 12:06
 */
public class No1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1.length == 0 && word2.length == 0) {
            return true;
        }
        if (word1.length == 0 ^ word2.length == 0) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }
        return sb1.toString().equals(sb2.toString());
    }

}
