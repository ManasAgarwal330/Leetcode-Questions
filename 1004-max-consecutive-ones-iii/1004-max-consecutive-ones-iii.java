class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int ans = Integer.MIN_VALUE;
        int countZeroes = 0;
        while(right < nums.length)
        {
            int val = nums[right];
            if(val == 0)
            {
                countZeroes++;
            }

            while(countZeroes > k){
                int val2 = nums[left];
                if(val2 == 0){
                    countZeroes--;
                }
                left++;
            }

            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}