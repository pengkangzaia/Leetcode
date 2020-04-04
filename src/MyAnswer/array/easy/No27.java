package MyAnswer.array.easy;

public class No27 {

    public static void main(String[] args){
        int[] nums = {2,2,3};
        int val = 2;
        int ans = new No27().removeElement(nums, val);
        System.out.println(ans);
    }




    public int removeElement(int[] nums, int val) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int temp;
        int j = nums.length - 1;
        for(int i = 0; i <= j; i++){
            while(nums[j]==val && i<j){
                if(j==0){
                    return 0;
                }
                j--;
            }
            if(nums[i]==val){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        return j + 1;

    }
}
