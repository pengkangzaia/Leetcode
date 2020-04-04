package MyAnswer.array.medium;

public class No134 {

    public static void main(String[] args) {
        No134 instance = new No134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int ans = instance.canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        //gas-cost=a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < n; i++) {
            //a[i]<0 ? 不是 : 继续
            if(a[i]>=0){
                int sum = 0;
                //从a[i]加到它自己
                int m = 0;
                while (sum>=0&&m<n){
                    sum+=a[(i+m)%n];
                    m++;
                }
                //任意一个sum<0 则不是
                if(sum<0){
                    continue;
                }

                //如果所有sum>=0 则是
                return i;
            }
        }

        //不能满足条件
        return -1;
    }
}
