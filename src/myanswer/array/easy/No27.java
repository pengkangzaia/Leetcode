package myanswer.array.easy;

public class No27 {

    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int ans = new No27().removeElement1(nums, val);
        System.out.println(ans);
    }




    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
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




    public int removeElement1(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[j] == val) {
                j--;
            } else {
                // 交换两个元素，i++，j不变
                swap(nums, i ,j);
                i++;
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
