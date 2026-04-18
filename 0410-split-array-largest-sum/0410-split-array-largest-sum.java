class Solution {
    public int splitArray(int[] nums, int k) {
        long left = Arrays.stream(nums).max().getAsInt();
        long right = Arrays.stream(nums).sum();
        long ans = Integer.MAX_VALUE;
        while(left <= right){
            long maxSum = (left + right)/2;
            if(splitPossible(nums,k,maxSum)){
                ans = maxSum;
                right = maxSum-1;
            }else{
                left = maxSum+1;
            }
        }   

        return (int)ans;
    }

    public boolean splitPossible(int[] nums, int splitAllowed,long maxSum){
        long sum = maxSum;
        for(int i=0;i<nums.length;i++){
            if(sum-nums[i] >= 0){
                sum -= nums[i];
            }else{
                splitAllowed--;
                if(splitAllowed == 0)return false;

                sum = maxSum - nums[i];
            }
        }

        return true;
    }
}