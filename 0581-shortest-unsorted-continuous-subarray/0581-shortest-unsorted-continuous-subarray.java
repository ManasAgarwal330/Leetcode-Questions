class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int startingIdx = -1;
        int endingIdx = -1;
        int currentMaxVal = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                startingIdx = i;
                break;
            }
        }

        if(startingIdx == -1)return 0;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i] < nums[i-1]){
                endingIdx = i;
                break;
            }
        }

        int min_val = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;

        for(int i=startingIdx;i<=endingIdx;i++){
            min_val = Math.min(min_val,nums[i]);
            max_val = Math.max(max_val,nums[i]);
        }

        while(startingIdx-1 >= 0 && nums[startingIdx-1] > min_val){
            startingIdx--;
        }
        while(endingIdx+1 <= nums.length-1 && nums[endingIdx+1] < max_val){
            endingIdx++;
        }
        return endingIdx - startingIdx + 1;
    }
}