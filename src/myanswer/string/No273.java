package myanswer.string;

public class No273 {

    // int 范围 ： 2,147,483,647
    // billion, million, thousand


    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }
        if (num < 1000) {
            return helper(num).trim();
        } else {
            int n = num;
            String res = "";
            int i = 0;
            while (n > 0) {

                String tem = "";
                // 这里注意！ (n / 1000) % 1000 != 0
                if (n >= 1000 && (n / 1000) % 1000 != 0) {
                    tem = UpThousand[i] + " " + tem;
                }
                if (n % 1000 != 0) {
                    tem += helper(n % 1000).trim() + " ";
                }
                i++;
                res = tem + res;
                n /= 1000;

            }
            return res.toString().trim();
        }
    }


    private final String[] BelowTwenty = {
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] Tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] UpThousand = {"Thousand", "Million", "Billion"};

    public String helper(int n) {
        if (n == 0) {
            return "";
        }
        if (n < 20) {
            return BelowTwenty[n - 1] + " ";
        } else if (n < 100) {
            if (n % 10 == 0) {
                return Tens[(n - 20) / 10] + " ";
            } else {
                return Tens[(n - 20) / 10] + " " + BelowTwenty[(n % 10) - 1] + " ";
            }
        } else if (n < 1000) {
            if (n % 100 == 0) {
                return BelowTwenty[(n / 100) - 1] + " " + "Hundred" + " ";
            } else {
                return BelowTwenty[(n / 100) - 1] + " " + "Hundred" + " " + helper((n % 100)) + " ";
            }
        }
        return "";
    }


    public static void main(String[] args) {
        int a = 21 % 10;
        System.out.println(a);
        // System.out.println(numberToWords(100));
        No273 no273 = new No273();
//        for (int i = 1; i < 99999999; i++) {
//            System.out.println(no273.numberToWords(i));
//        }
        //System.out.println(no273.numberToWords(1020001100));
        System.out.println(no273.numberToWords(1000256));

    }

}
