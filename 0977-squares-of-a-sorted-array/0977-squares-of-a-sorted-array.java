class Solution {
    public int[] sortedSquares(int[] nums) {
        int positive = 0;
        while(positive < nums.length && nums[positive] < 0){
            positive++;
        }

        int negative = positive-1;
        int[] ans = new int[nums.length];
        int ansIdx = 0;
        while(positive < nums.length && negative >= 0){
            int positiveSq = nums[positive] * nums[positive];
            int negativeSq = nums[negative] * nums[negative];

            if(positiveSq <= negativeSq){
                ans[ansIdx] = positiveSq;
                positive++;
            }else{
                ans[ansIdx] = negativeSq;
                negative--;
            }
            ansIdx++;
        }

        while(positive < nums.length){
            ans[ansIdx] = nums[positive] * nums[positive];
            ansIdx++;
            positive++;
        }

        while(negative >= 0){
            ans[ansIdx] = nums[negative] * nums[negative];
            ansIdx++;
            negative--;
        }

        return ans;
    }
}