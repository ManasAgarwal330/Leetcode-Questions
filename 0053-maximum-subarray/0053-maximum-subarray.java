class Solution {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(prev+nums[i] > nums[i]){
                prev = prev+nums[i];
                max = Math.max(max,prev);
            }else{
                prev = nums[i];
                max = Math.max(max,prev);
            }
        }

        return max;
    }
}