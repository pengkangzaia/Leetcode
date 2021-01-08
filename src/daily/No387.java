package daily;

/**
 * @FileName: No387.java
 * @Description: No387.java类说明
 * @Author: admin
 * @Date: 2020/12/23 10:19
 */
public class No387 {

    // 别人用数组的实现，存储的是出现频率。我写的存储的是索引
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
