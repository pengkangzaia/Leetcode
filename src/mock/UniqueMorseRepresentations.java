package mock;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: UniqueMorseRepresentations.java
 * @Description: UniqueMorseRepresentations.java类说明
 * @Author: admin
 * @Date: 2021/2/13 9:14
 */
public class UniqueMorseRepresentations {


    public int uniqueMorseRepresentations(String[] words) {
        String[] letterMap = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> encode = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(letterMap[word.charAt(j) - 'a']);
            }
            encode.add(sb.toString());
        }
        return encode.size();
    }

}
