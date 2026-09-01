class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;

        int res=nums[0];

        while(l<=r){
            // already in sorted part of array, in that case left is always going to be small in that range
            if(nums[l]<nums[r]){
                res=Math.min(res,nums[l]);
                break;
            }

            int m= l+(r-l)/2;
            // mid might be small
            res=Math.min(res,nums[m]);
            if(nums[m]>=nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
        }

        return res;

    }
}
