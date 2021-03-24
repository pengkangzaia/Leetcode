package mock.mock29;

/**
 * @FileName: DistributeCandies.java
 * @Description: DistributeCandies.java类说明
 * @Author: admin
 * @Date: 2021/3/24 17:19
 */
public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        // 分糖果问题
        int[] res = new int[num_people];
        int idx = 0, currCandies = 1;
        while (candies > currCandies) {
            candies -= currCandies;
            res[idx] += currCandies;
            currCandies++;
            idx++;
            idx = idx % num_people;
        }
        res[idx] += candies;
        return res;
    }

    public static void main(String[] args) {
        DistributeCandies d = new DistributeCandies();
        int candies = 10;
        int num_people = 3;
        int[] ans = d.distributeCandies(candies, num_people);
        for (int num : ans) {
            System.out.println(num);
        }
    }


}
