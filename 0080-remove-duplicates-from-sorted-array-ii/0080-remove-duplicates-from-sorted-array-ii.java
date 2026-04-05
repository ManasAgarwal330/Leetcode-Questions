class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int left = 0;
        int right = 1;
        while(right < nums.length)
        {
            if(nums[left] == nums[right] && left == 0){
                nums[left+1] = nums[right];
                left++;
                right++;
            }
            else if(nums[left] == nums[right] && nums[left] != nums[left-1]) // can have 2 occurences
            {
                nums[left+1] = nums[right];
                left++;
                right++;
            }else if(nums[left] != nums[right]){
                nums[left+1] = nums[right];
                left++;
                right++;
            }else{
                right++;
            }
        }

        return left+1;
    }
}