class Solution {
    public int maxProduct(int[] nums) {
        int prevSmallest = 1;
        int prevLargest = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int mulSmallest =  Math.min(nums[i] * prevSmallest, nums[i] * prevLargest);
            int mulLargest = Math.max(nums[i] * prevLargest, nums[i] * prevSmallest);
            
            if(mulLargest > nums[i]){
                prevLargest = mulLargest;
            }else{
                prevLargest = nums[i];
            }

            if(mulSmallest > nums[i]){
                prevSmallest = nums[i];
            }else{
                prevSmallest = mulSmallest;
            }

            

            max = Math.max(max,Math.max(prevLargest,prevSmallest));
        }

        return max;
    }
}