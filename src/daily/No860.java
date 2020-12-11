package daily;

/**
 * @FileName: No860.java
 * @Description: 柠檬水找零
 * @Author: admin
 * @Date: 2020/12/10 9:50
 */
public class No860 {

    // 何以为家里面就有卖柠檬水的片段 ^_^
    public boolean lemonadeChange(int[] bills) {
        // 维护一个当前持有金额，如果当前持有金额+5<付钱金额，则找不开
        int currSum = 0;
        int fiveCount = 0, tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                currSum += bills[i];
                fiveCount++;
            } else if (bills[i] == 10) {
                if (currSum + 5 < bills[i]) {
                    return false;
                }
                currSum += 5;
                fiveCount--;
                tenCount++;
            } else {
                if (currSum + 5 < bills[i]) {
                    return false;
                }
                currSum += 5;
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    fiveCount -= 3;
                }
            }
        }
        return true;
    }


    public boolean lemonadeChange1(int[] bills) {
        // 维护一个面值5元和10元总金额，如果当前持有金额+5<付钱金额，则找不开
        // 面值20的没有用，不能用于找零
        int currSum = 0;
        int tenCount = 0; // 当前持有的面值10元的个数
        // 根据上面两个可以算到面值5元的个数
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                currSum += 5;
            } else if (bills[i] == 10) {
                if (currSum + 5 < bills[i]) {
                    return false;
                }
                currSum += 5;
                tenCount++;
            } else {
                if (currSum + 5 < bills[i]) {
                    return false;
                }
                int fiveCount = (currSum - tenCount * 10) / 5; // 计算5元面值的个数
                if (fiveCount <= 0) {
                    return false; // 没有面值为5的纸币，怎么给15块找零？ -> 直接返回false
                }
                // 可以找零，但是面值5和面值10的加起来损失了15元
                currSum -= 15;
                // 优先放弃10元面值的。因为5元面值的更找得开
                if (tenCount > 0) {
                    tenCount--;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No860 no860 = new No860();
        // [5,5,5,5,10,5,10,10,10,20]
        int[] bills = {5, 5, 5, 5, 10, 5, 10, 10, 10, 20};
        boolean ans = no860.lemonadeChange1(bills);
        System.out.println(ans);
    }

}
