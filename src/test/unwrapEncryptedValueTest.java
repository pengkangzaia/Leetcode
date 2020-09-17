package test;

public class unwrapEncryptedValueTest {

    public static void main(String[] args) {
        String s = "dx_cipher_111";
        String substring = s.substring("dx_cipher".length());
        System.out.println(substring);
    }

}
