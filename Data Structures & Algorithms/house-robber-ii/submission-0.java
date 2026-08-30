class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
 
       return Math.max(
    robFun(Arrays.copyOfRange(nums, 0, nums.length - 1)),
    robFun(Arrays.copyOfRange(nums, 1, nums.length))
);
    }

    private int robFun(int[] nums){
        int prev1=0;
        int prev2=0;

        for(int num:nums){
            int curr = Math.max(prev1,prev2+num);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
