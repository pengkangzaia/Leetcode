package MyAnswer.array.easy;

public class No1103 {
    public static void main(String[] args) {
        int candies = 2;
        int num_people = 2;
        int[] a = new int[0];
        int[] ans = distributeCandies(candies,num_people);
    }

    private static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        if(candies==0){
            return ans;
        }
        int index = 0;
        int candyNow = 1;
        int restCandies = candies - candyNow;
        ans[index] = candyNow;
        index++;candyNow++;

        while (restCandies>0){
            if(restCandies>candyNow){
                restCandies -= candyNow;
                ans[index%num_people]+=candyNow;
                candyNow++;
                index++;
            }else {
                ans[index%num_people]+=restCandies;
                restCandies = 0;
            }
        }

        return ans;
    }
}
