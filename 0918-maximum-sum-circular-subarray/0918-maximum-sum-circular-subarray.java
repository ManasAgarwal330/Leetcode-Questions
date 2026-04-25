class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int prevMaxPositive = 0;
        int prevMaxNegative = 0;
        int maxPositive = Integer.MIN_VALUE;
        int maxNegative = Integer.MAX_VALUE;
        int arrSum = 0;

        for(int i=0;i<nums.length;i++){
            arrSum += nums[i];
            int curMaxPositive = prevMaxPositive + nums[i] > nums[i] ? prevMaxPositive + nums[i] : nums[i];
            int curMaxNegative = prevMaxNegative + nums[i] < nums[i] ? prevMaxNegative + nums[i] : nums[i];

            prevMaxPositive =  curMaxPositive;
            prevMaxNegative = curMaxNegative;

            maxPositive = Math.max(maxPositive,prevMaxPositive);
            maxNegative = Math.min(maxNegative,prevMaxNegative);
        }
        
        if(arrSum-maxNegative == 0){
            return maxPositive;
        }
        return maxPositive > arrSum-maxNegative ? maxPositive : arrSum-maxNegative ;
    }
}