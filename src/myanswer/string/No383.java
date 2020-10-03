package myanswer.string;

public class No383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote==null){
            return true;
        } else if(magazine==null || ransomNote.length() > magazine.length()){
            return false;
        } else {
            int[] count = new int[26];
            char[] m_chars = magazine.toCharArray();
            char[] r_chars = ransomNote.toCharArray();
            for (int i = 0; i < m_chars.length; i++) {
                count[m_chars[i] - 'a']++;
            }
            for (int i = 0; i < r_chars.length; i++) {
                count[r_chars[i] - 'a']--;
            }
            boolean flag = true;
            for (int i = 0; i < count.length; i++) {
                if (count[i] < 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

    }

    public static void main(String[] args) {
        No383 no383 = new No383();
        boolean ans = no383.canConstruct("aaa", "abwfwaca");
        System.out.println(ans);
    }

}
