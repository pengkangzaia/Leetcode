package test;

import java.util.Scanner;

/**
 * @FileName: ScannerTest.java
 * @Description: ScannerTest.java类说明
 * @Author: camille
 * @Date: 2021/2/19 20:41
 */
public class ScannerTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(s);
        }
    }

}
