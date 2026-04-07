class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left =0 ;
        while(left < nums.length){
            min = Math.min(nums[left],min);
            left++;
        }

        return min;
    }
}