package test;

public class CalTest {

    public static void main(String[] args) {
        double e = Math.E;
        double sum = Math.pow(e, 2) + Math.pow(e, -1) + Math.pow(e, 5) + Math.pow(e, 0);
        double[] nums = {2,-1,5,0};
        double[] res = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.pow(e, nums[i]) / sum;
            System.out.println(res[i]);
        }

    }

}
