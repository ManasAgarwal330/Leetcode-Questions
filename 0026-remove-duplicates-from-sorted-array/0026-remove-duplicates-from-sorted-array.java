class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return 1;
        }

        int left = 0;
        int right = 1;

        while(right < nums.length)
        {
            if(nums[left] != nums[right]){
                nums[left+1] = nums[right];
                right++;
                left++;
            }
            else{
                right++;
            }
        }
        return left+1;
    }
}