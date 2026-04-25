class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prevMaxPositive = 0;
        int prevMaxNegative = 0;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int curMaxPositive = prevMaxPositive + nums[i] > nums[i] ? prevMaxPositive + nums[i] : nums[i];
            int curMaxNegative = prevMaxNegative + nums[i] < nums[i] ? prevMaxNegative + nums[i] : nums[i];

            prevMaxPositive =  curMaxPositive;
            prevMaxNegative = curMaxNegative;

            ans = Math.max(ans,Math.max(Math.abs(prevMaxPositive),Math.abs(prevMaxNegative)));
        }

        return ans;
    }
}